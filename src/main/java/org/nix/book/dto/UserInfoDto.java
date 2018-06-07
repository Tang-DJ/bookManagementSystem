package org.nix.book.dto;

import org.nix.book.dto.base.AbstractResultDto;
import org.nix.book.model.UserInfoModel;

import java.util.List;

/**
 * @program: bookmanager
 * @description:
 * @author: Tang
 * @create: 2018-06-07 17:57
 **/

public class UserInfoDto extends AbstractResultDto {

    private List<UserInfoModel> userInfoDtos;

    public UserInfoDto(List<UserInfoModel> userInfoDtos) {
        this.userInfoDtos = userInfoDtos;
    }

    @Override
    public void handler() throws CloneNotSupportedException {
        for (UserInfoModel model:userInfoDtos) {
//            model.setLendedNum(0);
//            model.setMax(10);
//            model.setTime(new Date());
        }
    }

    public List<UserInfoModel> getUserInfoDtos() {
        return userInfoDtos;
    }

    public void setUserInfoDtos(List<UserInfoModel> userInfoDtos) {
        this.userInfoDtos = userInfoDtos;
    }
}
