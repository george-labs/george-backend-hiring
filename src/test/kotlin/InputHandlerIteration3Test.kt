import interfaces.InputHandlerInterface
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import service.InputHandlerService
import service.WordCountService
import java.io.ByteArrayInputStream

class InputHandlerIteration3Test {


    @Test
    fun `given emptyArguments when inputValidation then take Empty manual input`() {
        val emptyArray: Array<String> = emptyArray()
        val inputHandlerService: InputHandlerInterface = InputHandlerService()

        val result = inputHandlerService.inputValidation(emptyArray)
        assertEquals(result, "")
    }

    @Test
    fun `given emptyArguments when inputValidation then take Sentence manual input`() {
        val emptyArray: Array<String> = emptyArray()
        val inputHandlerService: InputHandlerInterface = InputHandlerService()

        val simulatedInput = "Mary had a little lamb"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))

        val result = inputHandlerService.inputValidation(emptyArray)
        assertEquals(result, simulatedInput)
    }

    @Test
    fun `given existingParameterArguments when inputValidation then get the existing file name, parse it and read its content`() {
        val mytext: Array<String> = arrayOf("mytext.txt")
        val inputHandlerService: InputHandlerInterface = InputHandlerService()

        val result = inputHandlerService.inputValidation(mytext)
        assertEquals(result, "Mary had\r\na little\r\nlamb")
    }

    @Test
    fun `given incorrect ParameterArguments when inputValidation then throw File was not found Error`() {
        val mytext: Array<String> = arrayOf("mytext1.txt")
        val inputHandlerService: InputHandlerInterface = InputHandlerService()

        assertThrows<Error> { inputHandlerService.inputValidation(mytext) }
    }

}