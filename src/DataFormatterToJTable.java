import java.util.ArrayList;

/**
 * Created by Nickolas on 05.11.2017.
 */
/*Форматирует данные в Object[][] для вывода в таблицу*/
public class DataFormatterToJTable {
    public static Object[][] formateArrayListToObjectArray(TenantsLinkedList tenants){



        Object[][] toJTable = new Object[tenants.size()][7];
        int positionCounter = 0; //счетчик позиции для занесения реквизитов жильца в массив объектов
        TenantsIterator tenantsIterator = new TenantsIterator(tenants);
        int i = 0;
        while (tenantsIterator.hasNext()){

            Tenant t = tenantsIterator.next();

            toJTable[positionCounter][0]  = t.street;
            toJTable[positionCounter][1]  = t.houseNumber;
            toJTable[positionCounter][2]  = t.apartmentNumber;
            toJTable[positionCounter][3]  = t.name;
            toJTable[positionCounter][4]  = t.phone;
            toJTable[positionCounter][5]  = t.squareOfApartment;
            toJTable[positionCounter][6]  = t.numberOfTenants;

            positionCounter++;
            i++;

        }


        return toJTable;
    }
}
