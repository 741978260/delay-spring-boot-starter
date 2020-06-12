package com.mumu.drools;

import com.mumu.drools.input.People;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/12
 */
@Slf4j
@Service
public class DroolsService {
    @Resource
    private KieSession kieSession;

    public void doTest() {
        People people = new People();
        people.setName("哒");
        people.setSex(1);
        people.setDrlType("people");
        // 插入
        kieSession.insert(people);
        // 执行规则
        kieSession.fireAllRules();
    }

    public void doCustomer() {
        //
        People people = new People();
        people.setName("哒");
        people.setSex(1);
        people.setDrlType("people");
        //
        KieServices kieServices = KieServices.Factory.get();
        StatelessKieSession kieSession = kieServices.getKieClasspathContainer().newStatelessKieSession("my-test");
        List<Command> commands = new ArrayList<>();
        KieCommands kieCommands = kieServices.getCommands();
        commands.add(kieCommands.newInsert(people, "input"));

        ExecutionResults execute = kieSession.execute(kieCommands.newBatchExecution(commands));

    }
}
