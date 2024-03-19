# Assumptions per iteration

## Iteration 1

- no special characters permitted (everywhere found in the word) 

> Enter text: fghfh$ jbkjb hjjDSFDfd jhgkj a A !@!#@#$@$#%#$^$#%^%$&&*)_+_()
> 
> Number of words: 5

- no digits

- min length input 0
- max length input fits into memory


- splitting words will be based upon the following chars and space:
> ,.?;!

## Iteration 1 - session 3

IOException could not be triggered , therefore could not be tested
Following is the failing test

```java
    @Test
    void test_GivenNullInput_thenThrowIOException() throws IOException {
        InputStream inputStream = getInputStream("");
        inputStream.close();

        testClass = new ConsoleInputReader(inputStream);

        final ReaderException ex = Assertions.assertThrows(ReaderException.class, () -> testClass.readInput());
        assertEquals("Fail: Error reading input", ex.getMessage());
    }
```
