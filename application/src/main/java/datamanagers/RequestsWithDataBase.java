package datamanagers;

import datamanagers.DAOOrganizations;
import datamanagers.DAOProducts;
import model.Organization;
import model.Product;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class RequestsWithDataBase {
    private static final DAOProducts daoProducts = new DAOProducts();
    private static final DAOOrganizations daoOrganizations = new DAOOrganizations();

    public  List<Product> getAllProductsFromDateBase() {
        return daoProducts.getListOfProductFromRecord(daoProducts.all());
    }

    public  List<Product> getProductsWithRightOrg(String org) {
        return daoProducts.getListOfProductFromRecord(daoProducts.getProductsWithRightOrg(org));
    }

    public String saveToDataBaseFromURL(@NotNull String info) {
        var infoAboutProduct = info.split(":");
        var productName = infoAboutProduct[0];
        var organizationName = infoAboutProduct[1];
        var amount = Integer.parseInt(infoAboutProduct[2]);
        if (daoOrganizations.isExist(organizationName)) {
            daoOrganizations.save(new Organization(organizationName));
        }
        daoProducts.save(productName, organizationName, amount);
        return "Product has been added";
    }


    public boolean findAndDeleteProductFromDataBase(@NotNull String nameOfProduct){
        if(daoProducts.isExist(nameOfProduct)){
            daoProducts.delete(nameOfProduct);
            return true;
        }
        else{
            return false;
        }
    }

}
