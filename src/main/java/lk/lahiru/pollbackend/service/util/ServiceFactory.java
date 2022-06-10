package lk.lahiru.pollbackend.service.util;

public class ServiceFactory {
private static ServiceFactory serviceFactory;

private ServiceFactory(){

}

public static  ServiceFactory getInstance(){
    return (serviceFactory==null)? (serviceFactory=new ServiceFactory()):serviceFactory;

}

public <T extends SuperService>T getService(ServiceType type){
    switch (type){
        case POLL:
            return null;
        default:
            return null;
    }
}

public enum ServiceType{
    POLL
}
}
