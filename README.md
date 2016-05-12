# WikidataPropertyTalkPageCrawler

This simple prgoram is used to extract metadata about [Wikidata](https://www.wikidata.org) properties from the corresponding talk pages.
For an example of a talk page, take a look on the talk page of the property ["educated at"](https://www.wikidata.org/wiki/Property_talk:P69).

The extracted metadata are the following:

- Description: a short description of the property
- Represents: the things that the property represents
- Data type: that data type (normally Wikidata item)
- Domain: the domain of the property, i.e., the types of the subject of the property
- Allowed values: the values that the property can take, i.e., the types of the object of the property
- Example: examples shwoing facts using that property

The extracted metadata are stored in text file. 
We used the crawler to extract the metadata for a [sample](input/Full_Prop_List.txt) of properties. The results can be found in [prop_talk_metadata.txt](output/prop_talk_metadata.txt).
