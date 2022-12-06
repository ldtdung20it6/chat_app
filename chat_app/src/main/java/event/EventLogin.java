/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package event;

import com.dung.model.Model_Login;
import com.dung.model.Model_Register;

/**
 *
 * @author TRUNG DUNG
 */
public interface EventLogin {
    public void login(Model_Login data);
    public void register(Model_Register data, EventMessage message);
    public void goRegister();
    public void goLogin();
}
