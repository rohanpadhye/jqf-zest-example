# JQF+Zest Example

## The test case

There is only source file in this repository: `PatriciaTrieTest.java`, which contains a simply property test for class `PatriciaTrie` from Apache Commons Collections.

Run `mvn test-compile` to compile the test.

## Fuzzing with Zest

```
mvn jqf:fuzz -Dclass=examples.PatriciaTrieTest -Dmethod=testTrie2Map -Dtime=1m
```

Run the above to fuzz with JQF running the Zest engine for 1 minute. It should usually take just a few seconds to find the failure, but there is of course randomness involved. CTRL+C to stop fuzzing at any time.

If the number of "Unique Failures" reported is non-zero, then run the following to repro the failing test case:

```
mvn jqf:repro -Dclass=examples.PatriciaTrieTest -Dmethod=testTrie2Map -Dinput=target/fuzz-results/examples.PatriciaTrieTest/testTrie2Map/failures/id_000000 -DprintArgs
```

You will most likely find bug [COLLECTIONS-714](https://issues.apache.org/jira/browse/COLLECTIONS-714). 

Since this is an extreme test, it is possible that sometimes JQF does not find a failure in the first attempt. If so, try running the `mvn jqf:fuzz` command again. For a more realistic test driver, see the official tutorial on [Fuzzing a Compiler](https://github.com/rohanpadhye/jqf/wiki/Fuzzing-a-Compiler).

## Compare to blind fuzzing

Run `mvn:test` to run vanilla junit-quickcheck. This will most likely lead to an error message saying that most trials do not meet the assumptions required by the test. 

You can also the JQF maven plugin to run this test without the use of code coverage feedback, but using the same status screen as when running coverage-guided fuzzing:
```
mvn jqf:fuzz -Dclass=examples.PatriciaTrieTest -Dmethod=testTrie2Map -Dtime=1m -Dblind
```

Running the above command in most cases will result in no interesting inputs being generated. It is very very unlikely that you will encounter a failing test case using blind fuzzing.




