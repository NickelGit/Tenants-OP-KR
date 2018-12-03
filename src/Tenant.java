/**
 * Created by Nickolas on 04.11.2017.
 */
public class Tenant {
    String name; //имя жильца
    String street,houseNumber, apartmentNumber; //адрес жильца (улица,№дома,№квартиры)
    String phone; //телефон жильца
    double squareOfApartment; //площадь квартиры
    int numberOfTenants; //количество жильцов
    double squarePerTenant; //количество квадратных метров на одного жильца
    String districtName; //название района
    String districtHead; //имя главы района
    private Tenant nextTenant = null;

    public Tenant(String name, String street, String houseNumber, String apartmentNumber, String phone,
                  double squareOfApartment, int numberOfTenants, String districtName, String districtHead){
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.phone = phone;
        this.squareOfApartment = squareOfApartment;
        this.numberOfTenants = numberOfTenants;
        this.districtName = districtName;
        this.districtHead = districtHead;
        squarePerTenant = squareOfApartment/numberOfTenants;
    }

    public Tenant getNextTenant() {
        return nextTenant;
    }

    public void setNextTenant(Tenant nextTenant) {
        this.nextTenant = nextTenant;
    }

    @Override
    public String toString(){
        String returnStr = name + "\n" + street + "\n" + houseNumber + "\n" + apartmentNumber + "\n" + phone
                + "\n" + squareOfApartment + "\n" + numberOfTenants + "\n" + districtName + "\n" + districtHead + "\n";

        return returnStr;
    }
}
