import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.itson.appweb.Register;

public class RegisterTest {

//    private Register registerServlet;
//    private HttpServletRequest mockRequest;
//    private HttpServletResponse mockResponse;
//    private RequestDispatcher mockRequestDispatcher;
//
//    @Before
//    public void setUp() {
//        registerServlet = new Register();
//        mockRequest = mock(HttpServletRequest.class);
//        mockResponse = mock(HttpServletResponse.class);
//        mockRequestDispatcher = mock(RequestDispatcher.class);
//    }
//
//    @Test
//    public void testValidRegistration() throws ServletException, IOException {
//        // Set up your mock request parameters as needed for a valid registration
//        when(mockRequest.getParameter("action")).thenReturn("register");
//        when(mockRequest.getParameter("mail-phone")).thenReturn("valid@email.com");
//        // Add other necessary parameters
//
//        // Mock the request dispatcher
//        when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);
//
//        // Call the method to be tested
//        registerServlet.doPost(mockRequest, mockResponse);
//
//        // Verify that the request dispatcher was called with the correct parameter
//        verify(mockRequestDispatcher).forward(mockRequest, mockResponse);
//
//        // You may add more assertions based on your specific logic
//    }
//
//    @Test
//    public void testInvalidRegistration() throws ServletException, IOException {
//        // Set up your mock request parameters as needed for an invalid registration
//        when(mockRequest.getParameter("action")).thenReturn("register");
//        when(mockRequest.getParameter("mail-phone")).thenReturn("");  // Invalid email
//
//        // Mock the request dispatcher
//        when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);
//
//        // Call the method to be tested
//        registerServlet.doPost(mockRequest, mockResponse);
//
//        // Verify that the request dispatcher was called with the correct parameter
//        verify(mockRequestDispatcher).forward(mockRequest, mockResponse);
//
//        // You may add more assertions based on your specific logic for handling invalid registrations
//    }
//
//    // Add more test cases as needed

}
