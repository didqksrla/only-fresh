package com.devkurly.order.controller;

import com.devkurly.address.domain.AddressDto;
import com.devkurly.coupon.domain.CouponDto;
import com.devkurly.coupon.domain.UserCouponDto;
import com.devkurly.coupon.service.CouponService;
import com.devkurly.member.dto.MemberUpdateResponseDto;
import com.devkurly.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.List;

import static com.devkurly.member.controller.MemberController.getMemberResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderRestController {

    private final MemberService memberService;

    @GetMapping("/coupon")
    public List<CouponDto> readCoupon(HttpSession session) {
        Integer user_id = getMemberResponse(session);
        return memberService.findCoupon(user_id);
    }

    @GetMapping("/userinfo")
    public MemberUpdateResponseDto readUserInfo(HttpSession session) {
        Integer user_id = getMemberResponse(session);
        return memberService.findUpdateMember(user_id);
    }

    @GetMapping("/address")
    public AddressDto readAddress(HttpSession session) {
        Integer user_id = getMemberResponse(session);
        return memberService.findAddress(user_id);
    }

}
