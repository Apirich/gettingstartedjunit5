package patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class ClinicCalendarShould{
    @Test
    public void allowEntryOfAnAppointment(){
        ClinicCalendar calendar = new ClinicCalendar();
        calendar.addAppointment("Test", "Test", "murphy", "07/17/2024 10:05 am");

        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1, appointments.size());

        PatientAppointment testAppt = appointments.get(0);
        assertEquals("Test", testAppt.getPatientFirstName());
        assertEquals("Test", testAppt.getPatientLastName());
        assertEquals(Doctor.murphy, testAppt.getDoctor());
        assertEquals("7/17/2024 10:05 AM", testAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/dd/yyyy hh:mm a")));
    }
}
