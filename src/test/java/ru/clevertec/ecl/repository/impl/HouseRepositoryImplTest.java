package ru.clevertec.ecl.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.clevertec.ecl.configuration.TestDatabaseConfig;
import ru.clevertec.ecl.entity.House;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
//@SpringJUnitConfig(classes = {TestDatabaseConfig.class})
@ContextConfiguration(classes = HouseRepositoryImpl.class)
@RequiredArgsConstructor
class HouseRepositoryImplTest {
    private final SessionFactory sessionFactory;
    private final HouseRepositoryImpl houseRepository;


//    @Autowired
//    public HouseRepositoryImplTest(HouseRepositoryImpl houseRepository, SessionFactory sessionFactory) {
//        this.houseRepository = houseRepository;
//        this.sessionFactory = sessionFactory;
//    }

//    @BeforeEach
//    void setUp() {
//        houseRepository = new HouseRepositoryImpl(); // Или инициализируйте его согласно вашей логике создания.
//    }

    @Test
    void findById() {
    }

    @Test
    void getResidents() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void testDelete() {
        // Test the repository method
        House house = new House();
        house.setCountry("TestCountry");
        house.setCity("TestCity");
        house.setStreet("TestStreet");
        house.setHouseNumber("TestHouseNumber");

        House createdHouse = houseRepository.create(house);

        UUID houseUuid = createdHouse.getUuid();

        // Delete the house
        houseRepository.delete(houseUuid);

        // Verify that the house is deleted
        assertNull(houseRepository.findById(houseUuid).orElse(null));
    }
}