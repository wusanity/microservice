package com.wzp.thrift.user.dto;

/**
 * @ClassName TeacherDTO
 * @Description TODO
 * @Author wuzph
 * @Date 2020/10/12 17:49
 */

public class TeacherDTO extends UserDTO{

    private String intro;
    private int stars;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
