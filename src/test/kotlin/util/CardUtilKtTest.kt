package util

import exception.InvalidDeckException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CardUtilKtTest : StringSpec({

    "should get validated deck of cards from string data" {
        val deck =
            getValidatedCards("H10, H7, HQ, D8, D6, C2, CQ, C8, DK, H2, CJ, S8, S7, S2, D4, HA, D3, S5, D10, DA, C6, C7, C10, SK, CK, H6, SQ, H3, S6, D7, H8, DQ, HJ, H4, CA, H9, S4, DJ, HK, SA, S3, D9, C4, S10, S9, D5, SJ, D2, C9, H5, C3, C5")
        deck.size shouldBe 52
        deck[0] shouldBe "H10"
        deck[4] shouldBe "D6"
    }

    "should throw exception on incomplete deck" {
        val e = shouldThrow<InvalidDeckException> { getValidatedCards("H10, H7, HQ, D8, D6, C2, CQ, C8, DK, H2") }
        e.message shouldBe "Please provide a deck on valid 52 cards."
    }

    "should throw exception on invalid cards in deck" {
        val e =
            shouldThrow<InvalidDeckException> { getValidatedCards("H10, H7, HQ, D8, D6, C2, CQ, C8, DK, H2, CJ, S8, S7, S2, D4, HA, D3, S5, D10, DA, C6, C7, C10, SK, CK, HH, SQ, H3, S6, D7, H8, DQ, HJ, H4, CA, H9, S4, DJ, HK, SA, S12, D9, C4, S10, S9, D5, SJ, D2, C9, H5, C3, C5") }
        e.message shouldBe "Invalid card(s) are found in the provided deck: [HH, S12]"
    }

    "should throw exception on repetitive cards in deck" {
        val e =
            shouldThrow<InvalidDeckException> { getValidatedCards("H10, D6, HQ, D8, D6, C2, CQ, C8, DK, H2, CJ, DK, S7, S2, D4, HA, D3, S5, D10, DA, C6, C7, C10, SK, CK, H6, SQ, H3, S6, D7, H8, DQ, HJ, H4, CA, H9, S4, DJ, HK, SA, S3, D9, C4, S10, S9, D5, SJ, D2, C9, H5, C3, C5") }
        e.message shouldBe "Please provide a deck of cards without repetition."
    }

    "should get correct card validation" {
        "H10".isValidCard() shouldBe true
        "CA".isValidCard() shouldBe true

        "S12".isValidCard() shouldBe false
        "8A".isValidCard() shouldBe false
        "S09".isValidCard() shouldBe false
    }

    "should get shuffled deck of cards" {
        val deck1 = getShuffledDeck()
        val deck2 = getShuffledDeck()

        deck1.size shouldBe 52
        deck2.size shouldBe 52

        deck1 shouldNotBe deck2
    }
})
