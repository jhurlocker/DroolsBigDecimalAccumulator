package com.sample;

import java.math.BigDecimal;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
        	Account account1 = new Account();
        	account1.setAccountBalance(new BigDecimal(100.01));
        	Account account2 = new Account();
        	account2.setAccountBalance(new BigDecimal(50.09));
            kSession.insert(account1);
            kSession.insert(account2);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Account {

        private BigDecimal accountBalance;

		public BigDecimal getAccountBalance() {
			return accountBalance;
		}

		public void setAccountBalance(BigDecimal accountBalance) {
			this.accountBalance = accountBalance;
		}
                
    }

}
