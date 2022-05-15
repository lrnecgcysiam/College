CISC 7512X HW# 8: (this homework is inspired by an interview question I've been asked): In this homework you'll be using this file:
<!-- [quotes_UsConsolidated_....txt.gz]. -->

This file includes US stock quote data. Each row is a quote. A quote could be from a single venue or a consolidated quote across all venues. Each file is 10 minutes for a subset of stocks.

File Specification: The first row from the sample file:
86|1|18:10:00.000|U|0||5|3|BP.N||3=13:09:59.993|1=16|0=39.93|2=0x52|8=13:09:59.993|6=21|5=39.94|11=2017-12-11|1715=13:09:59.993|7=0x52|1427=C|

Each row contains two parts:
The header is comprised of 10 pipe-delimited fields. The only relevant field for this problem is the 9th, the symbol.

Symbols have the form "AAA.BB" where AAA is the ticker and BB is the venue.
Quotes with symbols ending in "." (e.g. "AAA.") are consolidated quotes.
Quotes with venues specified (e.g. "AAA.BB") are venue quotes that contribute to the consolidated quotes for their ticker (e.g. "AAA.").

The body is comprised of a variable number of pipe-delimited key-value fields representing the latest known value for a ticker/venue combination.
If a key is missing, its value is retained from the prior entry for that ticker/venue. Values for a given ticker/venue are valid for a given trade date until explicitly updated.
If a key is specified but has no value (e.g. "|3=|") then the prior value does not carry over, but is instead missing. This may occur if, for example, a venue has no bids for a security at the moment.

The relevant keys are:
0: bid
1: bid size
3: bid time
5: ask
6: ask size
8: ask time
11: trade date

In general, both venue and consolidated quotes are valid until updated. The consolidated quote represents the highest valid bid (or lowest ask) across all venues. Certain condition codes on venue quotes can indicate that the venue is no longer valid for inclusion in the consolidated quote.

Task1: Write ETL code to save the following fields from the venue quotes in Parquet format:
ticker, date, time, venue, bid, bid size, ask, ask size.

The data written should be fully reflective of the state of the market as of each quoteâ€”i.e. if the current bid is unspecified in a row on the input because it is unchanged, it nonetheless should appear in the Parquet data. If the current bid is unavailable because it was explicitly nulled (i.e. a |0=| entry in the file) it should appear as a null in the Parquet data.

Task2: For each date, ticker and minute from 09:31 through 16:00, calculate the number of venues that are showing the same bid price as the consolidated quote at the end of the minute interval. Include only quotes for the trade date specified in the file name.

Submit the Spark program to do Task1 and Task2. 