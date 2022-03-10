package io.github.ziemowit.collectionshorts

import spock.lang.Specification

class ShortsTest extends Specification {

  def '''[LIST] map'''() {
    given:
    def input = List.of(new Person('Foo', 10), new Person('Bar', 20))

    when:
    def result = Shorts.map(input, { it.getName() })

    then:
    result == List.of('Foo', 'Bar')
  }

  def '''[LIST] filter'''() {
    given:
    def person1 = new Person('A', 10)
    def person2 = new Person('B', 20)
    def person3 = new Person('C', 30)
    def person4 = new Person('D', 40)
    def input = List.of(person1, person2, person3, person4)

    when:
    def result = Shorts.filter(input, { it.getAge() > 20 })

    then:
    result == List.of(person3, person4)
  }

  def '''[LIST] unique'''() {
    given:
    def input = List.of(1, 2, 2, 3, 4, 4, 4, 5)

    when:
    def result = Shorts.unique(input)

    then:
    result == List.of(1, 2, 3, 4, 5)
  }

  def '''[LIST] reverse'''() {
    given:
    def input = List.of(1, 2, 3, 4, 5)

    when:
    def result = Shorts.reverse(input)

    then:
    result == List.of(5, 4, 3, 2, 1)
  }

  def '''[SET] map'''() {
    given:
    def input = Set.of(new Person('Foo', 10), new Person('Bar', 20))

    when:
    def result = Shorts.map(input, { it.getName() })

    then:
    result == Set.of('Foo', 'Bar')
  }

  def '''[SET] filter'''() {
    given:
    def input = Set.of(
        new Person('Foo', 10),
        new Person('Bar', 20),
        new Person('Zar', 30))

    when:
    def result = Shorts.filter(input, { it.age >= 20 })

    then:
    result.size() == 2
    result.containsAll([new Person('Bar', 20), new Person('Zar', 30)])
  }

  def '''[MAP] groupByKey'''() {
    given:
    def person1 = new Person('A', 10)
    def person2 = new Person('B', 20)
    def person3 = new Person('C', 30)
    def person4 = new Person('D', 40)
    def input = List.of(person1, person2, person3, person4)

    when:
    def result = Shorts.groupByKey(input, { it.getName() })

    then:
    result == Map.of('A', new Person('A', 10),
                     'B', new Person('B', 20),
                     'C', new Person('C', 30),
                     'D', new Person('D', 40))
  }


}
