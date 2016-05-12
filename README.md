# WikidataPropertyTalkPageCrawler

This simple prgoram is used to extract metadata about [Wikidata](https://www.wikidata.org) properties from the corresponding talk pages.
The extracted metadata are the following:

- Description: a short description of the property
- Represents: the things that the property represents
- Data type: that data type (normally Wikidata item)
- Domain: the domain of the property, i.e., the types of the subject of the property
- Allowed values: the values that the property can take, i.e., the types of the object of the property
- Example: examples shwoing facts using that property

The extracted metadata are stored in text file.
