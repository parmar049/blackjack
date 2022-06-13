package com.demo.assignment.blackjack.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CardRank {
    C2("CLUB_TWO", 2), C3("CLUB_THREE", 3), C4("CLUB_FOUR", 4), C5("CLUB_FIVE", 5),
    C6("CLUB_SIX", 6), C7("CLUB_SEVEN", 7), C8("CLUB_EIGHT", 8), C9("CLUB_NINE", 9),
    C10("CLUB_TEN", 10), CJ("CLUB_JACK", 10), CQ("CLUB_QUEEN", 10), CK("CLUB_KINF", 10),
    CA("CLUB_ACE", 11), D2("DIAMOND_TWO", 2), D3("DIAMOND_THREE", 3), D4("DIAMOND_FOUR", 4),
    D5("DIAMOND_FIVE", 5), D6("DIAMOND_SIX", 6), D7("DIAMOND_SEVEN", 7), D8("DIAMOND_EIGHT", 8),
    D9("DIAMOND_NINE", 9), D10("DIAMOND_TEN", 10), DJ("DIAMOND_JACK", 10), DQ("DIAMOND_QUEEN", 10),
    DK("DIAMOND_KING", 10), DA("DIAMOND_ACE", 11), S2("SPADE_TWO", 2), S3("SPADE_THREE", 3),
    S4("SPADE_FOUR", 4), S5("SPADE_FIVE", 5), S6("SPADE_SIX", 6), S7("SPADE_SEVEN", 7),
    S8("SPADE_EIGHT", 8), S9("SPADE_NINE", 9), S10("SPADE_TEN", 10), SJ("SPADE_JACK", 10),
    SQ("SPADE_QUEEN", 10), SK("SPADE_KING", 10), SA("SPADE_ACE", 11), H2("HEART_TWO", 2),
    H3("HEART_THREE", 3), H4("HEART_FOUR", 4), H5("HEART_FIVE", 5), H6("HEART_SIX", 6),
    H7("HEART_SEVEN", 7), H8("HEART_EIGHT", 8), H9("HEART_NINE", 9), H10("HEART_TEN", 10),
    HJ("HEART_JACK", 10), HQ("HEART_QUEEN", 10), HK("HEART_KING", 10), HA("HEART_ACE", 11);

    private final String name;
    private final int value;

}


