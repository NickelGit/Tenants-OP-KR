/**
 * Created by Nickolas on 23.11.2017.
 */
public class TenantsLinkedList {
    Tenant firstTenant = null;
    Tenant lastElement = null;
    private int size = 0;

    public void cloneAdd(Tenant tenant){
        if(firstTenant == null){
            Tenant t = clone(tenant);
            firstTenant = t;
            lastElement = t;
            size++;
        }
        else{
            Tenant t = clone(tenant);
            lastElement.setNextTenant(t);
            lastElement = t;
            size++;
        }

    }

    public void add(Tenant tenant){
        if(firstTenant == null){
            firstTenant = tenant;
            lastElement = tenant;
            size++;
        }
        else{
            lastElement.setNextTenant(tenant);
            lastElement = tenant;
            size++;
        }

    }

    public void remove(Tenant tenant){

        TenantsIterator itr = new TenantsIterator(this);
        while(itr.hasNext()){

            Tenant next = itr.next();
            if(firstTenant.equals(tenant)){
                firstTenant = firstTenant.getNextTenant();
                size--;
                break;
            }
            else if(next.getNextTenant().equals(tenant) && lastElement.equals(tenant) ){
                next.setNextTenant(null);
                lastElement = next;
                size--;
                break;
            }
            else if(next.getNextTenant().equals(tenant)){
                next.setNextTenant(tenant.getNextTenant());
                size--;
                break;
            }
        }
    }

    public int size(){
        return size;
    }

    public Tenant clone(Tenant tenant){
        Tenant retrTenant = new Tenant(tenant.name, tenant.street, tenant.houseNumber, tenant.apartmentNumber,
                tenant.phone, tenant.squareOfApartment, tenant.numberOfTenants, tenant.districtName, tenant.districtHead);
        return retrTenant;
    }

}
