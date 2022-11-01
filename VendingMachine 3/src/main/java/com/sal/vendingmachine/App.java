
package com.sal.vendingmachine;

import com.sal.vendingmachine.controller.VendingMachineController;
import com.sal.vendingmachine.dao.*;
import com.sal.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sal.vendingmachine.service.VendingMachineItemInventoryException;
import com.sal.vendingmachine.service.VendingMachineService;
import com.sal.vendingmachine.service.VendingMachineServiceImpl;
import com.sal.vendingmachine.ui.UserIO;
import com.sal.vendingmachine.ui.UserIOImpl;
import com.sal.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author vicmaia
 */
public class App {
    public static void main(String[] args) throws VendingMachineException{
         /*
        Instantiate the UserIO, VendingMachineView, AuditDao,  VendingMachineDao, VendingMachineService,
        VendingMachineController class and call the run method
         */
        UserIO io = new UserIOImpl();
        VendingMachineView view = new VendingMachineView(io);
        AuditDao auditDao = new AuditDaoImpl();
        VendingMachineDao dao = new VendingMachineDaoImpl();
        VendingMachineService service = new VendingMachineServiceImpl(auditDao, dao);

        VendingMachineController controller = new VendingMachineController(view, service);

        controller.run();
    }
}
