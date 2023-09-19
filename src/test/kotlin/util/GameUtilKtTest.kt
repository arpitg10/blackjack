package util

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class GameUtilKtTest : StringSpec({

    "should get correct card score" {
        "HA".getCardScore() shouldBe 11
        "SJ".getCardScore() shouldBe 10
        "C8".getCardScore() shouldBe 8
    }
})
