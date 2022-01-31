package com.golab.userservice.Service;

import com.golab.userservice.Model.User;
import com.golab.userservice.Repository.UserRepository;
import com.golab.userservice.VO.MedicinskaUstanova;
import com.golab.userservice.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        MedicinskaUstanova medicinskaUstanova = restTemplate.getForObject("http://GO-LAB-MED-SERVICE:9090/"+ user.getMedUstanovaId()
                ,MedicinskaUstanova.class);
        vo.setUser(user);
        vo.setMedicinskaUstanova(medicinskaUstanova);
        return vo;
    }

}
