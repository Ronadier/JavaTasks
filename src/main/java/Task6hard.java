public class Task6hard {
}

/*
В качестве более сложной задачи мы к задаче номер 1 добавим еще немного методов:

8) Исправить все записи. Функция должна читать файл, анализировать - является ли пользователь на самом деле тином в текущей локации или нет, и при необходимости корректировать ему поле is_teen, перезаписывая файл.
9) Перевезти пользователя в текущую локацию. Локация приходит параметром. Если локация не одна из четырех - Россия, Япония, США, Тайланд - функция пишет, что не можно перевезти туда пользователя. Если страна из этих четырех - перевозит, меняя запись в файле и перепроверяя и корректирую поле is_teen при необходимости. Например, если мы пользователя, которому 18 лет, перевозим из РФ в США, он должен перестать считаться совершеннолетним.
10) Добавить страну. Да-да, выходит, что возраст совершеннолетия для страны надо хранить в каком-то конфиге, который можно дополнять. При вызове этого метода название страны приходит параметром, вторым параметром приходит возраст совершеннолетия. После добавления страны пользователей можно перевозить в эту страну также (метод 9).
 */