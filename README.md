# DbAton
### 1. Получать полный набор записи по любому из полей с одинаковой алгоритмической сложностью (не медленнее log(n));

Поиск осуществляется за O(1), так как используется HashMap для каждого поля.

### 2. Выбрать наиболее экономный способ хранения данных в памяти

Был выбрана HashMap, так как она явлется не самой требовательной структорой данных, однако если бы мы хотели уменьшить использование памяти, могли бы выбрать TreeMap (TreeMap может экономить память (по сравнению с HashMap), поскольку она использует только тот объем памяти, который необходим для хранения ее элементов, в отличие от HashMap, который использует непрерывную область памяти), однако время поиска увеличится.
