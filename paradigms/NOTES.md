```shell
~\IdeaProjects\paradigms-private\test git:[master]
./tuna.cmd ht SHalimova_Eva js-errors
paradigms
paradigms homework-test
Committing __current-repo
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean
Pushing __current-repo
Everything up-to-date
Pulling __local/git/SHalimova_Eva
remote: Enumerating objects: 16, done.
remote: Counting objects: 100% (16/16), done.
remote: Compressing objects: 100% (13/13), done.
remote: Total 13 (delta 8), reused 0 (delta 0)
Unpacking objects: 100% (13/13), 16.67 KiB | 230.00 KiB/s, done.
From https://www.kgeorgiy.info/git-students/year2023/SHalimova_Eva/paradigms
   59708da..12a4474  master     -> origin/master
Updating 59708da..12a4474
Fast-forward
 NOTES.md                                 | 4558 ++++++++++++++++++++++++++++++
 javascript-solutions/objectExpression.js |    6 +-
 2 files changed, 4560 insertions(+), 4 deletions(-)
 create mode 100644 NOTES.md
Removing __current-repo
Copying __local/git/SHalimova_Eva to __current-repo
commit 12a447475c2651dfb366201675b0173108359447
Author: SHalimova_Eva <409869@niuitmo.ru>
Date:   Thu Apr 4 18:00:47 2024 +0300

    HW7 AND HW8
Tests: running
WARNING: A command line option has enabled the Security Manager
WARNING: The Security Manager is deprecated and will be removed in a future release
Testing ProdGeom
    Testing: new Const(10)
    Testing: 10
    Testing:     10      
    Testing: new Variable('x')
    Testing: x
    Testing: x          
    Testing: new Variable('y')
    Testing: y
    Testing:           y
    Testing: new Variable('z')
    Testing: z
    Testing:         z  
    Testing: new Negate(new Variable('y'))
    Testing: (negate y)
    Testing: ( negate        y ) 
    Testing: new Add(new Variable('x'), new Const(2))
    Testing: (+ x 2)
    Testing:    (+ x   2     )
    Testing: new Subtract(new Const(3), new Variable('y'))
    Testing: (- 3 y)
    Testing: (-        3   y )
    Testing: new Multiply(new Const(4), new Variable('z'))
    Testing: (* 4 z)
    Testing:   ( *     4 z   )
    Testing: new Divide(new Const(5), new Variable('z'))
    Testing: (/ 5 z)
    Testing: ( /        5   z)
    Testing: new Divide(new Negate(new Variable('x')), new Const(2))
    Testing: (/ (negate x) 2)
    Testing:     (/    (negate x)   2) 
    Testing: new Divide(new Variable('x'), new Multiply(new Variable('y'), new Variable('z')))
    Testing: (/ x (* y z))
    Testing: (/   x     (*  y   z ))
    Testing: new Add(new Add(new Multiply(new Variable('x'), new Variable('x')), new Multiply(new Variable('y'), new Variable('y'))), new Multiply(new Variable('z'), new Variable('z')))
    Testing: (+ (+ (* x x) (* y y)) (* z z))
    Testing: (+ ( + (* x x) ( * y y) ) (*   z z)) 
    Testing: new Subtract(new Add(new Multiply(new Variable('x'), new Variable('x')), new Multiply(new Const(5), new Multiply(new Variable('z'), new Multiply(new Variable('z'), new Variable('z'))))), new Multiply(new Variable('y'), new Const(8)))
    Testing: (- (+ (* x x) (* 5 (* z (* z z)))) (* y 8))
    Testing: (- ( + (* x  x) ( * 5 (* z (* z  z)))) (* y 8))
    Testing: new Product(new Variable('x'))
    Testing: (product x)
    Testing: (product   x       ) 
    Testing: new Product(new Variable('x'), new Variable('y'), new Variable('z'))
    Testing: (product x y z)
    Testing: (    product  x   y   z) 
    Testing: new Product(new Variable('x'), new Variable('y'), new Variable('z'), new Const(3), new Const(5))
    Testing: (product x y z 3 5)
    Testing:   (product x y  z       3  5)
    Testing: new Product(new Add(new Variable('x'), new Const(2)))
    Testing: (product (+ x 2))
    Testing:  ( product     ( +  x 2  ))
    Testing: new Product(new Add(new Variable('x'), new Variable('y')))
    Testing: (product (+ x y))
    Testing: (product   (  + x  y   ))  
    Testing: new Product(new Const(1))
    Testing: (product 1)
    Testing:    (product    1)    
    Testing: new Product(new Variable('x'), new Variable('x'))
    Testing: (product x x)
    Testing: (product    x    x )   
    Testing: new Product(new Const(4), new Variable('x'), new Const(4))
    Testing: (product 4 x 4)
    Testing:   (product     4   x 4  )
    Testing: new Product(new Const(9), new Variable('x'), new Const(2), new Const(7))
    Testing: (product 9 x 2 7)
    Testing:  (  product  9   x    2 7 )
    Testing: new Product(new Variable('y'), new Const(3), new Variable('z'), new Variable('y'), new Variable('y'))
    Testing: (product y 3 z y y)
    Testing:  (product    y   3  z    y y)
    Testing: new Product(new Variable('x'), new Const(9), new Const(6), new Variable('z'), new Variable('y'), new Const(8))
    Testing: (product x 9 6 z y 8)
    Testing:  (product  x   9  6  z   y 8 )
    Testing: new Product(new Variable('y'), new Variable('y'), new Const(7), new Variable('y'), new Variable('z'), new Variable('x'), new Variable('z'))
    Testing: (product y y 7 y z x z)
    Testing:  (product  y   y 7    y z x z )
    Testing: new Product(new Variable('z'), new Const(2), new Variable('x'), new Variable('z'), new Const(0), new Const(8), new Variable('y'), new Const(2))
    Testing: (product z 2 x z 0 8 y 2)
    Testing: (product z  2 x   z 0     8 y 2) 
    Testing: new Product(new Const(5), new Variable('z'), new Const(4), new Const(8), new Const(0), new Const(6), new Variable('y'), new Const(1), new Variable('y'))
    Testing: (product 5 z 4 8 0 6 y 1 y)
    Testing: (product 5  z  4  8 0  6   y 1 y )
    Testing: new Geom(new Variable('x'))
    Testing: (geom x)
    Testing: (geom  x     )    
    Testing: new Geom(new Variable('x'), new Variable('y'), new Variable('z'))
    Testing: (geom x y z)
    Testing:     (geom     x   y z)
    Testing: new Geom(new Variable('x'), new Variable('y'), new Variable('z'), new Const(3), new Const(5))
    Testing: (geom x y z 3 5)
    Testing: ( geom x    y z  3  5  )  
    Testing: new Geom(new Add(new Variable('x'), new Const(2)))
    Testing: (geom (+ x 2))
    Testing:   ( geom  ( +    x 2 )) 
    Testing: new Geom(new Add(new Variable('x'), new Variable('y')))
    Testing: (geom (+ x y))
    Testing: (geom    (  +  x   y )) 
    Testing: new Geom(new Variable('x'))
    Testing: (geom x)
    Testing:    (geom      x)  
    Testing: new Geom(new Variable('z'), new Variable('x'))
    Testing: (geom z x)
    Testing: (geom  z     x)     
    Testing: new Geom(new Const(1), new Variable('z'), new Variable('y'))
    Testing: (geom 1 z y)
    Testing: (geom 1         z   y)
    Testing: new Geom(new Const(3), new Variable('z'), new Variable('z'), new Variable('y'))
    Testing: (geom 3 z z y)
    Testing: ( geom  3  z z        y)
    Testing: new Geom(new Variable('z'), new Const(8), new Const(6), new Const(9), new Const(6))
    Testing: (geom z 8 6 9 6)
    Testing: (geom   z  8  6  9      6)
    Testing: new Geom(new Const(9), new Variable('z'), new Const(3), new Variable('x'), new Const(2), new Const(1))
    Testing: (geom 9 z 3 x 2 1)
    Testing: ( geom   9  z  3 x      2 1)
    Testing: new Geom(new Const(3), new Variable('x'), new Const(8), new Variable('y'), new Const(4), new Variable('y'), new Variable('x'))
    Testing: (geom 3 x 8 y 4 y x)
    Testing:  ( geom 3 x  8    y 4  y   x) 
    Testing: new Geom(new Const(6), new Variable('z'), new Const(7), new Variable('x'), new Variable('y'), new Variable('x'), new Const(5), new Variable('y'))
    Testing: (geom 6 z 7 x y x 5 y)
    Testing:  (geom 6   z 7 x   y x  5    y)
    Testing: new Geom(new Const(7), new Variable('x'), new Const(5), new Variable('x'), new Variable('z'), new Variable('y'), new Variable('x'), new Const(4), new Variable('y'))
    Testing: (geom 7 x 5 x z y x 4 y)
    Testing: (geom 7   x 5   x z y    x 4  y)
    Random tests
        Completed   0 out of 88
Exception in thread "main" java.lang.AssertionError: Parsing error expected for 
        at jstest.prefix.ParserTester.assertParsingError(Unknown Source)
        at jstest.prefix.Kind.printParsingError(Unknown Source)
        at jstest.prefix.Kind.lambda$selector$1(Unknown Source)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at jstest.expression.BaseTester.test(Unknown Source)
        at jstest.expression.Builder.lambda$selector$4(Unknown Source)
        at base.Selector$Composite.lambda$v$0(Unknown Source)
        at base.Selector.lambda$test$2(Unknown Source)
        at base.Log.lambda$action$0(Unknown Source)
        at base.Log.silentScope(Unknown Source)
        at base.Log.scope(Unknown Source)
        at base.Log.scope(Unknown Source)
        at base.Selector.lambda$test$3(Unknown Source)
        at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        at base.Selector.test(Unknown Source)
        at base.Selector.main(Unknown Source)
        at jstest.prefix.FullPrefixTest.main(Unknown Source)
ERROR: Tests: failed
```
