package com.tigrenok.recipesapp.fragment;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tigrenok.recipesapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<RecipesRecycler> arrayList = new ArrayList<>();
    ArrayList<RecipesRecycler> searchList;

    String[] recipeIngredients = new String[]{
            "Ингредиенты: 1 ст. л. оливкового масла | 1 луковица, мелко нарезанная | 2 раздавленных зубчика чеснока, " +
                    "120 г чоризо нарезанных кубиками | 2 х 400 г банки измельченных помидоров | 1 ч. л. сахара | " +
                    "600 г свежих ньокки | 125 г моцареллы, нарезанной на кусочки | " +
                    "небольшой разорванный пучок базилика | зеленый салат для подачи",

            "Ингредиенты: Лимон ½ штуки | Оливковое масло 1,5 столовых ложек | Сахар щепотка | Петрушка 5 г | " +
                    "Семена кориандра щепотка | Чеснок 1,5 зубчиков | " +
                    "Красный лук 25 г | Чоризо 50 г | Маринованный перец 1,5 штук | Помидоры 1 штука | Куриное яйцо 3 штуки",

            "Ингредиенты: Тыква 1 кг | Репчатый лук 1 головка | Морковь 1 штука | Красный сладкий перец 1 штука | " +
                    "Корень имбиря 30 г | Чеснок 3 зубчика | Томатный соус пассата 400 г | Кокосовое молоко 400 мл | Рис басмати 360 г | " +
                    "Карри-порошок 1 столовая ложка | Молотый кориандр 1 чайная ложка | Куркума 1 чайная ложка | Кумин (зира) 1 чайная ложка | " +
                    "Молотый перец чили по вкусу | Соль по вкусу | Кинза по вкусу | Свежая мята по вкусу | Лайм по вкусу",
            "Ингредиенты: Вишня без косточек замороженная - 400 г | вишневая настойка (ликер или бренди) - 2 ст. л. | вишневый сок - 170 мл (образуется при варке вишен) |" +
                    "сахар - 2 ст. л. | крахмал - 0,5 ст. л. | сливки 38% жирности - 500 мл | сахарная пудра - 50 г\n" +
                    "Для бисквитного коржа: яйца - 6 шт. |  сахар - 150 г. | мука - 150 г | какао-порошок - 2 ст. л.\n" +
                    "Для отделки готового торта: горький шоколад - 100 г | коктейльная вишня (консервированная).",
            "Ингредиенты: 1 ст. л. оливкового масла | 1 луковица, мелко нарезанная | 2 раздавленных зубчика чеснока, " +
                    "120 г чоризо нарезанных кубиками | 2 х 400 г банки измельченных помидоров | 1 ч. л. сахара | " +
                    "600 г свежих ньокки | 125 г моцареллы, нарезанной на кусочки | " +
                    "небольшой разорванный пучок базилика | зеленый салат для подачи",

            "Ингредиенты: Лимон ½ штуки | Оливковое масло 1,5 столовых ложек | Сахар щепотка | Петрушка 5 г | " +
                    "Семена кориандра щепотка | Чеснок 1,5 зубчиков | " +
                    "Красный лук 25 г | Чоризо 50 г | Маринованный перец 1,5 штук | Помидоры 1 штука | Куриное яйцо 3 штуки",

            "Ингредиенты: Тыква 1 кг | Репчатый лук 1 головка | Морковь 1 штука | Красный сладкий перец 1 штука | " +
                    "Корень имбиря 30 г | Чеснок 3 зубчика | Томатный соус пассата 400 г | Кокосовое молоко 400 мл | Рис басмати 360 г | " +
                    "Карри-порошок 1 столовая ложка | Молотый кориандр 1 чайная ложка | Куркума 1 чайная ложка | Кумин (зира) 1 чайная ложка | " +
                    "Молотый перец чили по вкусу | Соль по вкусу | Кинза по вкусу | Свежая мята по вкусу | Лайм по вкусу",
            "Ингредиенты: Вишня без косточек замороженная - 400 г | вишневая настойка (ликер или бренди) - 2 ст. л. | вишневый сок - 170 мл (образуется при варке вишен) |" +
                    "сахар - 2 ст. л. | крахмал - 0,5 ст. л. | сливки 38% жирности - 500 мл | сахарная пудра - 50 г\n" +
                    "Для бисквитного коржа: яйца - 6 шт. |  сахар - 150 г. | мука - 150 г | какао-порошок - 2 ст. л.\n" +
                    "Для отделки готового торта: горький шоколад - 100 г | коктейльная вишня (консервированная).",
            "Ингредиенты: 1 ст. л. оливкового масла | 1 луковица, мелко нарезанная | 2 раздавленных зубчика чеснока, " +
                    "120 г чоризо нарезанных кубиками | 2 х 400 г банки измельченных помидоров | 1 ч. л. сахара | " +
                    "600 г свежих ньокки | 125 г моцареллы, нарезанной на кусочки | " +
                    "небольшой разорванный пучок базилика | зеленый салат для подачи",

            "Ингредиенты: Лимон ½ штуки | Оливковое масло 1,5 столовых ложек | Сахар щепотка | Петрушка 5 г | " +
                    "Семена кориандра щепотка | Чеснок 1,5 зубчиков | " +
                    "Красный лук 25 г | Чоризо 50 г | Маринованный перец 1,5 штук | Помидоры 1 штука | Куриное яйцо 3 штуки",

            "Ингредиенты: Тыква 1 кг | Репчатый лук 1 головка | Морковь 1 штука | Красный сладкий перец 1 штука | " +
                    "Корень имбиря 30 г | Чеснок 3 зубчика | Томатный соус пассата 400 г | Кокосовое молоко 400 мл | Рис басмати 360 г | " +
                    "Карри-порошок 1 столовая ложка | Молотый кориандр 1 чайная ложка | Куркума 1 чайная ложка | Кумин (зира) 1 чайная ложка | " +
                    "Молотый перец чили по вкусу | Соль по вкусу | Кинза по вкусу | Свежая мята по вкусу | Лайм по вкусу",
            "Ингредиенты: Вишня без косточек замороженная - 400 г | вишневая настойка (ликер или бренди) - 2 ст. л. | вишневый сок - 170 мл (образуется при варке вишен) |" +
                    "сахар - 2 ст. л. | крахмал - 0,5 ст. л. | сливки 38% жирности - 500 мл | сахарная пудра - 50 г\n" +
                    "Для бисквитного коржа: яйца - 6 шт. |  сахар - 150 г. | мука - 150 г | какао-порошок - 2 ст. л.\n" +
                    "Для отделки готового торта: горький шоколад - 100 г | коктейльная вишня (консервированная).",
    };
    String[] recipeText = new String[]{
            "\n1. Разогрейте масло в сковороде на среднем огне. Обжарьте лук и чеснок в течение 8-10 минут до мягкости.\n\n" +
                    "2. Добавьте чоризо и жарьте еще 5 минут.\n\n" +
                    "3. Добавьте помидоры и сахар, приправьте.\n\n" +
                    "4. Доведите до кипения, затем добавьте ньокки и готовьте 8 минут, часто помешивая, до мягкости.\n\n" +
                    "5. Разогрейте гриль до высокой температуры.\n\n" +
                    "6. Перемешайте ¾ моцареллы и большую часть базилика с ньокки.\n\n" +
                    "7. Разделите смесь между шестью огнеупорными рамекинами или выложите в одну форму для выпечки.\n\n" +
                    "8. Сверху выложите оставшуюся моцареллу и жарьте 3 минуты, или пока сыр не расплавится и не приобретет золотистый цвет.\n\n" +
                    "9. Приправьте, посыпьте оставшимся базиликом и подавайте с зеленым салатом.\n\n",

            "\n1. Припустить на оливковом маcле мелко нарезанные лук и чеснок. Так, чтобы они чуть размягчились, но еще не начали жариться.\n\n" +
                    "2. Добавить рубленые помидоры и перцы и тушить еще две минуты.\n\n" +
                    "3. После чего выжать в сковороду сок лимона, всыпать рубленую петрушку, сахар и подержать на огне еще минуту, энергично помешивая.\n\n" +
                    "4. Снять с огня и переложить содержимое сковороды в подходящую емкость.\n" +
                    "5. Обжарить на оливковом масле семена кориандра и тонкие ломтики чоризо, уделив каждой стороне колбасы секунд двадцать.\n\n" +
                    "6. Разбить в сковороду яйца, добавить помидорно-перечный соус (это, кстати, у него имя — ранчерос, а хуэвос — это про яйца) и жарить до готовности.\n\n",

            "\n1. Нарежьте очищенную тыкву в виде кубиков размером 1-2 см. Имбирь, чеснок, лук и перец чили мелко порубите.\n\n" +
                    "2. Разогрейте сковороду, налейте на нее масло и обжарьте в нем на среднем огне в течении 3-6 минут имбирь, лук, чеснок.\n\n" +
                    "3. Добавьте в сковороду перец чили вместе со всеми сухими специями. Жарьте в течении 1-1,5 минут, постоянно перемешивая. Затем добавьте тыкву и жарьте еще 1-2 минуты.\n\n" +
                    "4. Налейте в сковороду кокосовое молоко вместе с водой, добавьте соль и сахар по вкусу. Увеличьте огонь под сковородой на максимум, постоянно мешая смесь из ингредиентов доведите ее до кипения.\n\n" +
                    "5. После закипания, уменьшите до минимума огонь и продолжите тушить карри под крышкой примерно 30-40 минут до мягкости тыквенных кусочков.\n\n" +
                    "6. Если есть желание сделать карри более густым, то отделите часть полученной массы на сковороде, пропустите ее через блендер и смешайте полученное пюре с карри.",

            "\n1. Разогреть духовку на 180 гр. Приготовить бисквит, для этого в миске слегка на водяной бане подогреть яйца с сахаром до 30 г, " +
                    "венчиком немного взбить, затем взбить миксером до бела, взбивать минут 10, чтобы масса увеличилась в 4 раза.\n\n" +
                    "2. Затем в отдельной емкости просеять муку с какао и добавить частями в яичную смесь, перемешивая очень аккуратно лопаткой, чтобы яйца не осели, иначе бисквит не поднимется.\n\n" +
                    "3. Вылить тесто в смазанную маслом форму, выпекать 30-40 минут при т. 180 гр.\n\n" +
                    "4. Сделать начинку. Вишню поставить на огонь, добавить сахар, после того как закипит, добавить крахмал, разведенный в 50 г воды, перемешать и варить минут 5-10 до загустения.\n\n" +
                    "5. Остудить, слить сироп, разбавить с вишневой настойкой.\n\n" +
                    "6. Вынуть готовый бисквит и остудить.\n\n" +
                    "7. Разрезать бисквит на 2 части и пропитать вишневым сиропом.\n\n" +
                    "8. Сливки взбить с сахарной пудрой и ванилином до устойчивой пены. Сначала пропитать каждый корж сиропом, затем смазать кремом, на крем выложить вишню и закрыть коржом, так же сделать со следующим коржом, кроме верхнего. " +
                    "На верхний корж распределить взбитые сливки, также обмазать края торта и украсить тертым или струганым шоколадом и консервированными вишнями. Приятного!",

            "\n1. Разогрейте масло в сковороде на среднем огне. Обжарьте лук и чеснок в течение 8-10 минут до мягкости.\n\n" +
                    "2. Добавьте чоризо и жарьте еще 5 минут.\n\n" +
                    "3. Добавьте помидоры и сахар, приправьте.\n\n" +
                    "4. Доведите до кипения, затем добавьте ньокки и готовьте 8 минут, часто помешивая, до мягкости.\n\n" +
                    "5. Разогрейте гриль до высокой температуры.\n\n" +
                    "6. Перемешайте ¾ моцареллы и большую часть базилика с ньокки.\n\n" +
                    "7. Разделите смесь между шестью огнеупорными рамекинами или выложите в одну форму для выпечки.\n\n" +
                    "8. Сверху выложите оставшуюся моцареллу и жарьте 3 минуты, или пока сыр не расплавится и не приобретет золотистый цвет.\n\n" +
                    "9. Приправьте, посыпьте оставшимся базиликом и подавайте с зеленым салатом.\n\n",

            "\n1. Припустить на оливковом маcле мелко нарезанные лук и чеснок. Так, чтобы они чуть размягчились, но еще не начали жариться.\n\n" +
                    "2. Добавить рубленые помидоры и перцы и тушить еще две минуты.\n\n" +
                    "3. После чего выжать в сковороду сок лимона, всыпать рубленую петрушку, сахар и подержать на огне еще минуту, энергично помешивая.\n\n" +
                    "4. Снять с огня и переложить содержимое сковороды в подходящую емкость.\n" +
                    "5. Обжарить на оливковом масле семена кориандра и тонкие ломтики чоризо, уделив каждой стороне колбасы секунд двадцать.\n\n" +
                    "6. Разбить в сковороду яйца, добавить помидорно-перечный соус (это, кстати, у него имя — ранчерос, а хуэвос — это про яйца) и жарить до готовности.\n\n",

            "\n1. Нарежьте очищенную тыкву в виде кубиков размером 1-2 см. Имбирь, чеснок, лук и перец чили мелко порубите.\n\n" +
                    "2. Разогрейте сковороду, налейте на нее масло и обжарьте в нем на среднем огне в течении 3-6 минут имбирь, лук, чеснок.\n\n" +
                    "3. Добавьте в сковороду перец чили вместе со всеми сухими специями. Жарьте в течении 1-1,5 минут, постоянно перемешивая. Затем добавьте тыкву и жарьте еще 1-2 минуты.\n\n" +
                    "4. Налейте в сковороду кокосовое молоко вместе с водой, добавьте соль и сахар по вкусу. Увеличьте огонь под сковородой на максимум, постоянно мешая смесь из ингредиентов доведите ее до кипения.\n\n" +
                    "5. После закипания, уменьшите до минимума огонь и продолжите тушить карри под крышкой примерно 30-40 минут до мягкости тыквенных кусочков.\n\n" +
                    "6. Если есть желание сделать карри более густым, то отделите часть полученной массы на сковороде, пропустите ее через блендер и смешайте полученное пюре с карри.",

            "\n1. Разогреть духовку на 180 гр. Приготовить бисквит, для этого в миске слегка на водяной бане подогреть яйца с сахаром до 30 г, " +
                    "венчиком немного взбить, затем взбить миксером до бела, взбивать минут 10, чтобы масса увеличилась в 4 раза.\n\n" +
                    "2. Затем в отдельной емкости просеять муку с какао и добавить частями в яичную смесь, перемешивая очень аккуратно лопаткой, чтобы яйца не осели, иначе бисквит не поднимется.\n\n" +
                    "3. Вылить тесто в смазанную маслом форму, выпекать 30-40 минут при т. 180 гр.\n\n" +
                    "4. Сделать начинку. Вишню поставить на огонь, добавить сахар, после того как закипит, добавить крахмал, разведенный в 50 г воды, перемешать и варить минут 5-10 до загустения.\n\n" +
                    "5. Остудить, слить сироп, разбавить с вишневой настойкой.\n\n" +
                    "6. Вынуть готовый бисквит и остудить.\n\n" +
                    "7. Разрезать бисквит на 2 части и пропитать вишневым сиропом.\n\n" +
                    "8. Сливки взбить с сахарной пудрой и ванилином до устойчивой пены. Сначала пропитать каждый корж сиропом, затем смазать кремом, на крем выложить вишню и закрыть коржом, так же сделать со следующим коржом, кроме верхнего. " +
                    "На верхний корж распределить взбитые сливки, также обмазать края торта и украсить тертым или струганым шоколадом и консервированными вишнями. Приятного!",

            "\n1. Разогрейте масло в сковороде на среднем огне. Обжарьте лук и чеснок в течение 8-10 минут до мягкости.\n\n" +
                    "2. Добавьте чоризо и жарьте еще 5 минут.\n\n" +
                    "3. Добавьте помидоры и сахар, приправьте.\n\n" +
                    "4. Доведите до кипения, затем добавьте ньокки и готовьте 8 минут, часто помешивая, до мягкости.\n\n" +
                    "5. Разогрейте гриль до высокой температуры.\n\n" +
                    "6. Перемешайте ¾ моцареллы и большую часть базилика с ньокки.\n\n" +
                    "7. Разделите смесь между шестью огнеупорными рамекинами или выложите в одну форму для выпечки.\n\n" +
                    "8. Сверху выложите оставшуюся моцареллу и жарьте 3 минуты, или пока сыр не расплавится и не приобретет золотистый цвет.\n\n" +
                    "9. Приправьте, посыпьте оставшимся базиликом и подавайте с зеленым салатом.\n\n",

            "\n1. Припустить на оливковом маcле мелко нарезанные лук и чеснок. Так, чтобы они чуть размягчились, но еще не начали жариться.\n\n" +
                    "2. Добавить рубленые помидоры и перцы и тушить еще две минуты.\n\n" +
                    "3. После чего выжать в сковороду сок лимона, всыпать рубленую петрушку, сахар и подержать на огне еще минуту, энергично помешивая.\n\n" +
                    "4. Снять с огня и переложить содержимое сковороды в подходящую емкость.\n" +
                    "5. Обжарить на оливковом масле семена кориандра и тонкие ломтики чоризо, уделив каждой стороне колбасы секунд двадцать.\n\n" +
                    "6. Разбить в сковороду яйца, добавить помидорно-перечный соус (это, кстати, у него имя — ранчерос, а хуэвос — это про яйца) и жарить до готовности.\n\n",

            "\n1. Нарежьте очищенную тыкву в виде кубиков размером 1-2 см. Имбирь, чеснок, лук и перец чили мелко порубите.\n\n" +
                    "2. Разогрейте сковороду, налейте на нее масло и обжарьте в нем на среднем огне в течении 3-6 минут имбирь, лук, чеснок.\n\n" +
                    "3. Добавьте в сковороду перец чили вместе со всеми сухими специями. Жарьте в течении 1-1,5 минут, постоянно перемешивая. Затем добавьте тыкву и жарьте еще 1-2 минуты.\n\n" +
                    "4. Налейте в сковороду кокосовое молоко вместе с водой, добавьте соль и сахар по вкусу. Увеличьте огонь под сковородой на максимум, постоянно мешая смесь из ингредиентов доведите ее до кипения.\n\n" +
                    "5. После закипания, уменьшите до минимума огонь и продолжите тушить карри под крышкой примерно 30-40 минут до мягкости тыквенных кусочков.\n\n" +
                    "6. Если есть желание сделать карри более густым, то отделите часть полученной массы на сковороде, пропустите ее через блендер и смешайте полученное пюре с карри.",

            "\n1. Разогреть духовку на 180 гр. Приготовить бисквит, для этого в миске слегка на водяной бане подогреть яйца с сахаром до 30 г, " +
                    "венчиком немного взбить, затем взбить миксером до бела, взбивать минут 10, чтобы масса увеличилась в 4 раза.\n\n" +
                    "2. Затем в отдельной емкости просеять муку с какао и добавить частями в яичную смесь, перемешивая очень аккуратно лопаткой, чтобы яйца не осели, иначе бисквит не поднимется.\n\n" +
                    "3. Вылить тесто в смазанную маслом форму, выпекать 30-40 минут при т. 180 гр.\n\n" +
                    "4. Сделать начинку. Вишню поставить на огонь, добавить сахар, после того как закипит, добавить крахмал, разведенный в 50 г воды, перемешать и варить минут 5-10 до загустения.\n\n" +
                    "5. Остудить, слить сироп, разбавить с вишневой настойкой.\n\n" +
                    "6. Вынуть готовый бисквит и остудить.\n\n" +
                    "7. Разрезать бисквит на 2 части и пропитать вишневым сиропом.\n\n" +
                    "8. Сливки взбить с сахарной пудрой и ванилином до устойчивой пены. Сначала пропитать каждый корж сиропом, затем смазать кремом, на крем выложить вишню и закрыть коржом, так же сделать со следующим коржом, кроме верхнего. " +
                    "На верхний корж распределить взбитые сливки, также обмазать края торта и украсить тертым или струганым шоколадом и консервированными вишнями. Приятного!",

    };
    String[] recipesList = new String[]{
            "Ньокки запеченные с чоризо и моцареллой ", "Уэвос ранчерос", "Карри из кокоса и тыквы", "Шварцвальд",
            "Ньокки запеченные с чоризо и моцареллой ", "Уэвос ранчерос", "Карри из кокоса и тыквы", "Шварцвальд",
            "Ньокки запеченные с чоризо и моцареллой ", "Уэвос ранчерос", "Карри из кокоса и тыквы", "Шварцвальд"
    };
    String[] recipesInfo = new String[]{"45 мин", "20 мин", "30 мин", "45 мин",
            "45 мин", "20 мин", "30 мин", "45 мин",
            "45 мин", "20 мин", "30 мин", "45 мин"};
    int[] image = new int[]{R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        searchView = view.findViewById(R.id.searchView);
        recyclerView = view.findViewById(R.id.recycleView);
        searchView.setIconified(false);
        searchView.clearFocus();

        if (arrayList.isEmpty()) {
            for(int i = 0; i < recipesList.length; i++){
                RecipesRecycler recipesRecycler = new RecipesRecycler();
                recipesRecycler.setRecipeIngredients(recipeIngredients[i]);
                recipesRecycler.setRecipeText(recipeText[i]);
                recipesRecycler.setRecipesTitle(recipesList[i]);
                recipesRecycler.setRecipesInfo(recipesInfo[i]);
                recipesRecycler.setImage(image[i]);
                arrayList.add(recipesRecycler);
            }
        }


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecipesAdapter recipesAdapter = new RecipesAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(recipesAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList = new ArrayList<>();

                if (query.length() > 0){
                    for(int i = 0; i < arrayList.size(); i++){
                        if (arrayList.get(i).getRecipesTitle().toUpperCase().contains(query.toUpperCase())
                                || arrayList.get(i).getRecipesTitle().toUpperCase().contains(query.toUpperCase())){

                            RecipesRecycler recipesRecycler = new RecipesRecycler();
                            recipesRecycler.setRecipeIngredients(arrayList.get(i).getRecipeIngredients());
                            recipesRecycler.setRecipeText(arrayList.get(i).getRecipeText());
                            recipesRecycler.setRecipesTitle(arrayList.get(i).getRecipesTitle());
                            recipesRecycler.setRecipesInfo(arrayList.get(i).getRecipesInfo());
                            recipesRecycler.setImage(arrayList.get(i).getImage());
                            searchList.add(recipesRecycler);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);

                    RecipesAdapter recipesAdapter = new RecipesAdapter(getActivity(), searchList);
                    recyclerView.setAdapter(recipesAdapter);


                }else {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);

                    RecipesAdapter recipesAdapter = new RecipesAdapter(getActivity(), arrayList);
                    recyclerView.setAdapter(recipesAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                searchList = new ArrayList<>();

                if (newText.length() > 0){
                    for(int i = 0; i < arrayList.size(); i++){
                        if (arrayList.get(i).getRecipesTitle().toUpperCase().contains(newText.toUpperCase())
                                || arrayList.get(i).getRecipesTitle().toUpperCase().contains(newText.toUpperCase())){

                            RecipesRecycler recipesRecycler = new RecipesRecycler();
                            recipesRecycler.setRecipeIngredients(arrayList.get(i).getRecipeIngredients());
                            recipesRecycler.setRecipeText(arrayList.get(i).getRecipeText());
                            recipesRecycler.setRecipesTitle(arrayList.get(i).getRecipesTitle());
                            recipesRecycler.setRecipesInfo(arrayList.get(i).getRecipesInfo());
                            recipesRecycler.setImage(arrayList.get(i).getImage());
                            searchList.add(recipesRecycler);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);

                    RecipesAdapter recipesAdapter = new RecipesAdapter(getActivity(), searchList);
                    recyclerView.setAdapter(recipesAdapter);


                }else {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);

                    RecipesAdapter recipesAdapter = new RecipesAdapter(getActivity(), arrayList);
                    recyclerView.setAdapter(recipesAdapter);
                }

                return false;
            }
        });



        return view;
    }


}