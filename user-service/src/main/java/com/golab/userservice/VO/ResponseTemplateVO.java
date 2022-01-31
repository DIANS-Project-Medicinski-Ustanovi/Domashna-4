package com.golab.userservice.VO;

import com.golab.userservice.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private User user;
    private MedicinskaUstanova medicinskaUstanova;
}
