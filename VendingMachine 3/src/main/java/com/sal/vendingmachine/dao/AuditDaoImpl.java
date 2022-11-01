
package com.sal.vendingmachine.dao;

import com.sal.vendingmachine.dao.AuditDao;
import com.sal.vendingmachine.dao.VendingMachineException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author vicmaia
 */
public class AuditDaoImpl implements AuditDao{
    private static final String AUDIT_FILE = "audit.txt";
    //Default constructor
    /*
    public AuditDaoImpl() {
        this.AUDIT_FILE = "audit.txt";
    }
    //Contructor for testing
    public AuditDaoImpl(String auditTestFile) {
        this.AUDIT_FILE = auditTestFile;
    }

     */


    @Override
    public void writeAuditEntry(String entry) throws VendingMachineException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VendingMachineException("Could not persist audit information", e);
        }
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " +entry);
        out.flush();
    }
    
}
