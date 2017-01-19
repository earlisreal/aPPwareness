package com.github.paolorotolo.appintro;

public interface ISlidePolicy {
    boolean isPolicyRespected();

    void onUserIllegallyRequestedNextPage();
}
