//package com.BrightSkies.karim.FlightsBookingSystem.DataLayer;
//
//import com.BrightSkies.karim.FlightsBookingSystem.Models.Flights;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//@Repository
//@Qualifier("2")
//public interface FlightsD extends JpaRepository<Flights, Long> {
////    private final JdbcTemplate jdbcT;
////    @Autowired
////    public FlightsD(JdbcTemplate jdbcT){
////        this.jdbcT = jdbcT;
////    }
//////    public List<Flights> getAllFlights(){
////        final String sql = "Select * FROM flights";
////        System.out.println("i got here");
////        List<Flights> x = jdbcT.query(sql,(resultSet, i) -> new Flights(Integer.getInteger(resultSet.getString("FlightID")),
////                resultSet.getString("Location"),
////                resultSet.getString("Destination"),
////                resultSet.getTime("ArrivalTime"),
////                resultSet.getTime("Departure"),
////                Integer.getInteger(resultSet.getString("Fare"))));
////        System.out.println(jdbcT.query(sql,(resultSet, i) -> new String(resultSet.toString())));
////        return x;
////    }
//}
