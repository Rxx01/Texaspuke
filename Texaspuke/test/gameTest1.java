import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gameTest1 {

    @Test
    void compare() {//tdd建立测试
        assertEquals("White wins",new game().compare("2H 3D 5S 9C KD","2C 3H 4S 8C AH"));
        assertEquals("White wins",new game().compare("2H 4S 4C 2D 4H","2S 8S AS QS 3S"));
        assertEquals("Black wins",new game().compare("2H 3H 5H 9H KH","2C 3H 4S 5C 6H"));
        assertEquals("Tie",new game().compare("2H 3D 5S 9C KD","2D 3H 5C 9S KH"));
    }
}