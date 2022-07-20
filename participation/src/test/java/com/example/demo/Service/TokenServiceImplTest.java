package com.example.demo.Service;

import com.example.demo.FeignClient.AuthClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TokenServiceImplTest {

    @InjectMocks
    TokenServiceImpl tokenServiceImpl;

    @Mock
    AuthClient authClient;



    @Test
    void checkValidityWhenTokenIsNull() {

        assertThrows(NullPointerException.class,()-> tokenServiceImpl.checkValidity("token"));

    }

    @Test
    void checkValidityWhenTokenIsValid() {

        when(authClient.getValidity("token")).thenReturn(true);

        assertEquals(true, tokenServiceImpl.checkValidity("token"));

    }

    @Test
    void checkValidityWhenTokenIsInValid() {

        when(authClient.getValidity("token")).thenReturn(false);

        assertFalse(tokenServiceImpl.checkValidity("token"));

    }
}