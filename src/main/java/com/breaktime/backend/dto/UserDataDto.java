package com.breaktime.backend.dto;

import lombok.ToString;
import nl.martijndwars.webpush.Subscription;

@ToString
public class UserDataDto {
    public String email;
    public Subscription subscriptionData;

}
