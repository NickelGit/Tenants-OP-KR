/**
 * Created by Nickolas on 23.11.2017.
 */
public class TenantsIterator {
    TenantsLinkedList tenantsLinkedList;
    Tenant currentTenant;
    public TenantsIterator(TenantsLinkedList tenantsLinkedList){
        this.tenantsLinkedList = tenantsLinkedList;
        currentTenant = tenantsLinkedList.firstTenant;
    }

    public boolean hasNext(){
        if(currentTenant != null){
            return true;
        }
        else{
            return false;
        }
    }

    public Tenant next(){
        Tenant retrTenant = currentTenant;
        currentTenant = retrTenant.getNextTenant();
        return retrTenant;
    }

}
