package util

import exception.FileNotFoundException

class FileReader {
    companion object {
        fun getFileDataAsString(fileName: String): String =
            this::class.java.classLoader.getResource(fileName)?.readText(Charsets.UTF_8)
                ?: throw FileNotFoundException("Please provide a valid file name, $fileName is not found")
    }
}
