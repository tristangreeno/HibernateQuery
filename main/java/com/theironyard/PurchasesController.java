package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Controller for the application. Allows the user to search for purchases made by a specific customer.
 */
@Controller
public class PurchasesController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category){
        // Add HTML fields to allow entry of categories to select and narrow down the list
        // Default to findAll if entry is null
        List<Purchase> purchaseList = (List<Purchase>) purchases.findAll();

        if(category != null) {
            purchaseList = purchases.findByCategory(category);
        }
        model.addAttribute("purchases", purchaseList);
        return "home";
    }

    @PostConstruct
    public void init() throws FileNotFoundException {
        File f1 = new File("/Users/tristangreeno/workspace/Purchases/src/99c8adfe-customers.csv");
        Scanner scanner = new Scanner(f1);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");
            customers.save(new Customer(columns[0], columns[1]));
        }

        File f = new File("/Users/tristangreeno/workspace/Purchases/src/6f448979-purchases.csv");
        scanner = new Scanner(f);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");
            Integer id = Integer.parseInt(columns[0]);
            Customer customer = customers.findById(id);
            purchases.save(new Purchase(id, columns[1], columns[2], columns[3], columns[4], customer));
        }
    }
}
