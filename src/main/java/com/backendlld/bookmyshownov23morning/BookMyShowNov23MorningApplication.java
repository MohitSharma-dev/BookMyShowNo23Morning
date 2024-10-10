package com.backendlld.bookmyshownov23morning;

import com.backendlld.bookmyshownov23morning.controllers.BookingController;
import com.backendlld.bookmyshownov23morning.controllers.UserController;
import com.backendlld.bookmyshownov23morning.dtos.BookTicketRequestDTO;
import com.backendlld.bookmyshownov23morning.dtos.BookTicketResponseDTO;
import com.backendlld.bookmyshownov23morning.dtos.SignUpRequestDTO;
import com.backendlld.bookmyshownov23morning.dtos.SignUpResponseDTO;
import com.backendlld.bookmyshownov23morning.models.Feature;
import com.backendlld.bookmyshownov23morning.models.Region;
import com.backendlld.bookmyshownov23morning.models.Screen;
import com.backendlld.bookmyshownov23morning.models.Theatre;
import com.backendlld.bookmyshownov23morning.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowNov23MorningApplication implements CommandLineRunner {
    UserController userController;
    BookingController bookingController;
    RegionRepository regionRepository;

    @Autowired
    BookMyShowNov23MorningApplication(
            UserController userController,
            BookingController bookingController,
            RegionRepository regionRepository
    ){
        this.userController = userController;
        this.bookingController = bookingController;
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO requestDTO = new SignUpRequestDTO();
        requestDTO.setEmail("mohit.sharma1@scaler.com");
        requestDTO.setPassword("mohit");

        SignUpResponseDTO responseDTO = userController.signUp(requestDTO);
        System.out.println(responseDTO.getMessage());

        loadDataForBookTicket();

        BookTicketRequestDTO requestDTO2 = new BookTicketRequestDTO();
        requestDTO2.setShowId(1);
        requestDTO2.setShowSeatIds(List.of(1 , 2 , 3));
        requestDTO2.setUserId(1);

        BookTicketResponseDTO responseDTO1 = bookingController.bookTicket(requestDTO2);
        System.out.println(responseDTO1);
    }

    public void loadDataForBookTicket(){
        Region region = new Region();
        region.setRegionName("Bangalore");
        regionRepository.save(region);

        Theatre theatre = new Theatre();
        theatre.setRegion(region);
        theatre.setTheatreName("PVR : Director's Cut");
        theatre.setTheatreAddress("Church Street, MG Road");

        Screen screen = new Screen();
        screen.setTheatre(theatre);
        screen.setScreenName("Screen 1");
        screen.setFeatures(List.of(Feature.TWO_D));

//        Set up the remaining data
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowNov23MorningApplication.class, args);
    }

}
