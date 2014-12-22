package com.nadia.crackcode.gof.enterprise;

/**
 * Business Delegate Pattern is used to decouple presentation tier and business tier. It is
 * basically use to reduce communication or remote lookup functionality to business tier code in
 * presentation tier code. In business tier we've following entities.
 * <ul>
 * <li>Client - Presentation tier code may be JSP, servlet or UI java code.</li>
 * <li>Business Delegate - A single entry point class for client entities to provide access to
 * Business Service methods.</li>
 * <li>LookUp Service - Lookup service object is responsible to get relative business
 * implementation and provide business object access to business delegate object.</li>
 * <li>Business Service - Business Service interface. Concrete classes implement this
 * business service to provide actual business implementation logic.</li>
 * </ul>
 */
public class BusinessDelegatePattern {

    public static void main (String[] args) {
        Client client = new Client(new BusinessDelegate(BusinessLookUp.Type.EJB));
        client.doTask();

        client = new Client(new BusinessDelegate(BusinessLookUp.Type.JMS));
        client.doTask();
    }

    private interface BusinessService{
        void doProcessing();
    }

    private static class JMSService implements BusinessService{

        @Override
        public void doProcessing() {
            System.out.println("J M S Processing");
        }
    }

    private static class EJBService implements BusinessService{

        @Override
        public void doProcessing() {
            System.out.println("E J B Processing");
        }
    }

    private static class BusinessLookUp {
        public enum Type {
            EJB, JMS
        }
        private BusinessService getBusinessService(Type serviceName) {
            System.out.println("Switching serviceName " + serviceName + "...");
            switch (serviceName) {
                case EJB:
                    return new EJBService();
                case JMS:
                    return new JMSService();
                default:
                    return new JMSService();
            }
        }
    }

    private static class BusinessDelegate {
        BusinessLookUp lookUp;
        BusinessService service;
        BusinessLookUp.Type serviceType;

        public BusinessDelegate(BusinessLookUp.Type serviceType) {
            this.serviceType = serviceType;
            this.lookUp = new BusinessLookUp();
            this.service = this.lookUp.getBusinessService(serviceType);
        }

        public void doTask() {
            System.out.println("Delegating task ...");
            this.service.doProcessing();
        }
    }

    private static class Client {
        BusinessDelegate delegate;

        private Client(BusinessDelegate delegate) {
            this.delegate = delegate;
        }

        public void doTask() {
            System.out.println("Client (JSP) calls task ...");
            delegate.doTask();
        }
    }
}
