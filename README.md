# Refactoring to Patterns – Replace Implicit Tree with Composite

*Replace Implicit Tree with Composite* is one of the refactorings described in Chapter 7 of the book [Refactoring to Patterns](https://industriallogic.com/xp/refactoring/).

The commits in this repository try to mimic the test-driven steps described in the example section of the chapter. The first commit represents the initial state with the implicit tree in the ```OrdersWriter``` class.  

We report below the mechanics of this refactoring.

### Mechanics

1. Identify an *implicit leaf*, a part of the implicit tree that could be modeled with a new class. This new class will be a *leaf node* (called Composite:Leaf in [Design Patterns](https://en.wikipedia.org/wiki/Design_Patterns)). Create a leaf node class by applying refactorings like *Extract Class* or by doing test-driven development – whichever is easier given your context. If the implicit leaf has attributes, produce equivalents for these attributes in the leaf node, such that the representation of the entire leaf node, including its attributes, matches that of the implicit leaf.

    ✅ Compile and test.

2. Replace every occurrence of the implicit leaf with an instance of the leaf node, such that the implicit tree now relies on the leaf node instead of the implicit leaf.
   
    ✅ Compile and test that the implicit tree still functions correctly.

3. Repeat steps 1 and 2 for any additional parts of the implicit tree that represent an implicit leaf. Make sure that all lead nodes you create share a common interface. You can create this interface by applying *Extract Superclass* or *Extract Interface*.
4. Identify an *implicit parent*, a part of the implicit tree that acts as a parent to implicit leaves. The implicit parent will become a parent node class (called Composite). Develop this class by applying refactorings or doing test-driven development – again, using whichever approach is easier in your context. Clients must be able to add leaf nodes to the parent node either through a constructor or an ```add(...)``` method. The parent node must treat all children identically (i.e., via their common interface). The parent node may or may not implement the common interface. If clients must be able to add parent nodes to parent nodes (as is mentioned in step 6) or if you don't want client code to distinguish between a leaf node and a parent node, make the parent node implement the common interface.
   
    ✅ Compile and test.

5. Replace every occurrence of the implicit parent with code that uses a parent node instance, outfitted with the correct leaf node instances.

   ✅ Compile and test that the implicit tree still functions correctly.

6. Repeat step 4 and 5 for all additional implicit parents. Make it possible to add a parent node to a parent node only if your implicit parents support similar behavior.