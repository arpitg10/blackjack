package util

import exception.FileNotFoundException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import util.FileReader.Companion.getFileDataAsString

class FileReaderTest : StringSpec({
    "should read data from file correctly" {
        getFileDataAsString("testDeck.txt") shouldBe "DA, D3, DK, D7, H4, C3, H8, HK, D5, SJ, DQ, HA, C2, H10, H3, HQ, D4, C7, DJ, HJ, D8, CK, C4, C10, H6, S8, H2, S4, C9, SK, C5, C6, CA, S6, S9, D9, C8, S5, H5, SA, CQ, D2, S10, S7, D6, S3, SQ, H9, H7, D10, S2, CJ"
    }

    "should throw exception with message for file not found" {
        val fileName = "newDeck.txt"
        val e = shouldThrow<FileNotFoundException> { getFileDataAsString(fileName) }
        e.message shouldBe "Please provide a valid file name, $fileName is not found"
    }
})
