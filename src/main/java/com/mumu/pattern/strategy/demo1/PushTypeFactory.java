package com.mumu.pattern.strategy.demo1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/16
 */
@Component
public class PushTypeFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    private static Map<PushTypeEnum, PushTypeService> map = new HashMap<>(8);

    /**
     * 赋值
     *
     * @param applicationContext 上下文对象
     *
     * @throws BeansException 异常
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(PushType.class);
        for (Object obj : beanMap.values()) {
            PushType annotation = obj.getClass().getAnnotation(PushType.class);
            PushTypeFactory.map.put(annotation.value(), (PushTypeService) obj);
        }
    }

    /**
     * 匹配推送类型处理类
     *
     * @param mode   方式
     * @param system 系统
     *
     * @return 推送类型处理类
     */
    public Optional<PushTypeService> selectType(String mode, String system) {
        PushTypeEnum anEnum = PushTypeEnum.getPushTypeEnum(mode, system);
        return Optional.ofNullable(PushTypeFactory.map.get(anEnum));
    }
}
