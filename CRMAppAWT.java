import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CRMAppAWT {
    private List<Customer> customers = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();
    private int nextCustomerId = 1;

    public static void main(String[] args) {
        CRMAppAWT crmAppAWT = new CRMAppAWT();
        crmAppAWT.setupUI();
    }

    public void setupUI() {
        Frame frame = new Frame("CRM System");
        frame.setSize(600, 300);
        frame.setLayout(null);

        Label nameLabel = new Label("Name:");
        nameLabel.setBounds(30, 50, 50, 20);

        TextField nameTextField = new TextField();
        nameTextField.setBounds(90, 50, 150, 20);

        Label emailLabel = new Label("Email:");
        emailLabel.setBounds(30, 80, 50, 20);

        TextField emailTextField = new TextField();
        emailTextField.setBounds(90, 80, 150, 20);

        Label phoneLabel = new Label("Phone:");
        phoneLabel.setBounds(30, 110, 50, 20);

        TextField phoneTextField = new TextField();
        phoneTextField.setBounds(90, 110, 150, 20);

        Label locationLabel = new Label("Location:");
        locationLabel.setBounds(30, 140, 60, 20);

        TextField locationTextField = new TextField();
        locationTextField.setBounds(90, 140, 150, 20);

        Button addButton = new Button("Add Customer");
        addButton.setBounds(30, 180, 120, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String phone = phoneTextField.getText();
                String location = locationTextField.getText();
                int customerId = nextCustomerId++;
                Customer customer = new Customer(customerId, name, email, phone, location);
                customers.add(customer);
                System.out.println("Customer added: " + customer);
                clearTextFields(nameTextField, emailTextField, phoneTextField, locationTextField);
            }
        });

        Button displayButton = new Button("Display Customers");
        displayButton.setBounds(160, 180, 120, 30);
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomersDialog();
            }
        });

        frame.add(nameLabel);
        frame.add(nameTextField);
        frame.add(emailLabel);
        frame.add(emailTextField);
        frame.add(phoneLabel);
        frame.add(phoneTextField);
        frame.add(locationLabel);
        frame.add(locationTextField);
        frame.add(addButton);
        frame.add(displayButton);

        // Employee and Sale UI components
        Label empNameLabel = new Label("Employee Name:");
        empNameLabel.setBounds(250, 50, 100, 20);

        TextField empNameTextField = new TextField();
        empNameTextField.setBounds(350, 50, 150, 20);

        Label empIdLabel = new Label("Employee ID:");
        empIdLabel.setBounds(250, 80, 100, 20);

        TextField empIdTextField = new TextField();
        empIdTextField.setBounds(350, 80, 150, 20);

        // Corrected placement for empCustomerIdLabel and empCustomerIdTextField
        Label empCustomerIdLabel = new Label("Customer ID:");
        empCustomerIdLabel.setBounds(250, 110, 100, 20);

        TextField empCustomerIdTextField = new TextField();
        empCustomerIdTextField.setBounds(350, 110, 150, 20);

        // Sale fields
        Label saleAmountLabel = new Label("Sale Amount:");
        saleAmountLabel.setBounds(250, 140, 100, 20);

        TextField saleAmountTextField = new TextField();
        saleAmountTextField.setBounds(350, 140, 150, 20);

        // Add Employee and Sale Buttons
        Button addEmployeeButton = new Button("Add Employee");
        addEmployeeButton.setBounds(300, 180, 120, 30);
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empName = empNameTextField.getText();
                String empId = empIdTextField.getText();
                int empCustomerId = Integer.parseInt(empCustomerIdTextField.getText());
                Employee employee = new Employee(empName, empId, empCustomerId);
                employees.add(employee);
                System.out.println("Employee added: " + employee);
                clearTextFields(empNameTextField, empIdTextField, empCustomerIdTextField);
            }
        });

        Button addSaleButton = new Button("Add Sale");
        addSaleButton.setBounds(430, 180, 120, 30);
        addSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String saleAmountStr = saleAmountTextField.getText();
                double saleAmount = Double.parseDouble(saleAmountStr);
                Sale sale = new Sale(saleAmount);
                sales.add(sale);
                System.out.println("Sale added: " + sale);
                clearTextFields(saleAmountTextField);
            }
        });

        frame.add(empNameLabel);
        frame.add(empNameTextField);
        frame.add(empIdLabel);
        frame.add(empIdTextField);
        frame.add(empCustomerIdLabel);
        frame.add(empCustomerIdTextField);
        frame.add(saleAmountLabel);
        frame.add(saleAmountTextField);
        frame.add(addEmployeeButton);
        frame.add(addSaleButton);

        // Show Employees and Sales Button
        Button showEmployeesAndSalesButton = new Button("Show Employees and Sales");
        showEmployeesAndSalesButton.setBounds(300, 220, 200, 30);
        showEmployeesAndSalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEmployeesAndSalesDialog();
            }
        });
        frame.add(showEmployeesAndSalesButton);

        frame.setVisible(true);
    }

    private void clearTextFields(TextField... textFields) {
        for (TextField textField : textFields) {
            textField.setText("");
        }
    }

    private void showCustomersDialog() {
        StringBuilder message = new StringBuilder("List of Customers:\n");
        for (Customer customer : customers) {
            message.append(customer).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Customers", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showEmployeesAndSalesDialog() {
        StringBuilder message = new StringBuilder("List of Employees:\n");
        for (Employee employee : employees) {
            message.append(employee).append("\n");
        }

        message.append("\nList of Sales:\n");
        for (Sale sale : sales) {
            message.append(sale).append("\n");
        }

        JOptionPane.showMessageDialog(null, message.toString(), "Employees and Sales", JOptionPane.INFORMATION_MESSAGE);
    }

    private static class Customer {
        private int customerId;
        private String name;
        private String email;
        private String phone;
        private String location;

        public Customer(int customerId, String name, String email, String phone, String location) {
            this.customerId = customerId;
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email +
                    ", phone=" + phone + ", location=" + location + "]";
        }
    }

    private static class Employee {
        private String empName;
        private String empId;
        private int empCustomerId;

        public Employee(String empName, String empId, int empCustomerId) {
            this.empName = empName;
            this.empId = empId;
            this.empCustomerId = empCustomerId;
        }

        @Override
        public String toString() {
            return "Employee [empName=" + empName + ", empId=" + empId + ", empCustomerId=" + empCustomerId + "]";
        }
    }

    private static class Sale {
        private double saleAmount;

        public Sale(double saleAmount) {
            this.saleAmount = saleAmount;
        }

        @Override
        public String toString() {
            return "Sale [saleAmount=" + saleAmount + "]";
        }
    }
}
