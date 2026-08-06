package com.ateew.clicandrun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.dto.RegisterDto;
import com.ateew.clicandrun.model.Athlete;
import com.ateew.clicandrun.model.Nationality;
import com.ateew.clicandrun.model.Role;
import com.ateew.clicandrun.model.User;
import com.ateew.clicandrun.repository.AthleteRepository;
import com.ateew.clicandrun.repository.NationalityRepository;
import com.ateew.clicandrun.repository.UserRepository;
import com.ateew.clicandrun.exception.EmailAlreadyExistsException;
import com.ateew.clicandrun.exception.NationalityNotFoundException;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private NationalityRepository nationalityRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(RegisterDto dto) {

        if (userRepository.findByEmail(dto.getEmail()) != null) {
            throw new EmailAlreadyExistsException(dto.getEmail());
        }

        Athlete athlete = athleteRepository.findByFirstNameAndLastNameAndBirthDate(
            dto.getFirstName(), dto.getLastName(), dto.getBirthDate());

        if (athlete == null) {
            Nationality nationality = nationalityRepository.findById(dto.getNationalityId())
                .orElseThrow(() -> new NationalityNotFoundException(dto.getNationalityId()));

            athlete = new Athlete();
            athlete.setFirstName(dto.getFirstName());
            athlete.setLastName(dto.getLastName());
            athlete.setBirthDate(dto.getBirthDate());
            athlete.setNationality(nationality);
            athlete = athleteRepository.save(athlete);
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.USER);
        user.setAthlete(athlete);

        return userRepository.save(user);
    }
}