# Word Count VIII

Optionally the text can be checked against a dictionary of known words. If the index is printed it will mark words not found in the dictionary with a star and state the number of unknown words, e.g.

```shell
$ wordcount -index -dictionary=dict.txt
Enter text: Mary had a little lamb
Number of words: 4, unique: 4; average word length: 4.25 characters
Index (unknown: 2):
had
lamb*
little
Mary*
$
```

With `dict.txt` being:

```text
big
small
little
cat
dog
have
has
had
```