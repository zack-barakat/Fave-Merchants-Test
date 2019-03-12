package com.android.favemerchants.data

import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.data.model.MerchantsResponse
import com.google.gson.Gson

class TestDataGenerator {
    companion object {

        private val gson = Gson()

        fun getMerchantsResponse(): MerchantsResponse {
            return gson.fromJson(
                "{\n" +
                        "    \"took\": 1,\n" +
                        "    \"timed_out\": false,\n" +
                        "    \"_shards\": {\n" +
                        "        \"total\": 5,\n" +
                        "        \"successful\": 5,\n" +
                        "        \"skipped\": 0,\n" +
                        "        \"failed\": 0\n" +
                        "    },\n" +
                        "    \"hits\": {\n" +
                        "        \"total\": 594,\n" +
                        "        \"max_score\": 1,\n" +
                        "        \"hits\": [\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"Above Gastrobar\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"Above Gastrobar\",\n" +
                        "                    \"description\": \"Tucked down a red brick road in Ipoh is the gastronomic venture, Above Gastrobar, that offers a delectable selection of tapas-style dishes. Their menu takes inspiration from various international cuisines while focusing on local ingredients and produce grown in their very own herb garden. With individuality and finesse to offer, the gastrobar complements their food galore with an array of wines for casuals and connoisseurs alike.\",\n" +
                        "                    \"website\": \"https://www.facebook.com/abovegastrobar/\",\n" +
                        "                    \"email\": \"\",\n" +
                        "                    \"country\": \"kuala-lumpur\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"ABS AUTO SERVICES\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"ABS AUTO SERVICES\",\n" +
                        "                    \"description\": \"As a certified Castrol auto service workshop, ABS Auto Services provides car maintenance and servicing to all. Situated in Setapak, the repair shop strives to be a one-stop car service centre for various cars. Some services provided include computerised wheel alignment and balancing, wiring, flush and change of auto-transmission fluid, and many more. Visit their workshop for an oil change or car check up today.\",\n" +
                        "                    \"website\": \"\",\n" +
                        "                    \"email\": \"\",\n" +
                        "                    \"country\": \"kuala-lumpur\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"Ace Beauty Sense And Spa\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"Ace Beauty Sense And Spa\",\n" +
                        "                    \"description\": \"Serving patrons out of their Setia Alam beauty salon and spa, therapists at Ace Beauty Sense and Spa offer facials, massages, and other varieties of wellness services to suit all skintypes and dispositions.\",\n" +
                        "                    \"country\": \"kuala-lumpur\",\n" +
                        "                    \"website\": \"\",\n" +
                        "                    \"email\": \"janicechia0803@gmail.com\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"Aceskin Beaute & Wellness\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"Aceskin Beaute & Wellness\",\n" +
                        "                    \"description\": \"Located on the 2nd floor of Plaza Ivory, Aceskin Beaute & Wellness welcomes clients to a pampering rereat. Boasting soothing periwinkle blue walls, the centre envelopes clients with a calming ambiance as dedicated beauticians tend to lethargic bodies with an array of treatments like intensive hydrating facials, ear candling, and more.\",\n" +
                        "                    \"website\": \"https://www.facebook.com/aceskinbeaute1122/\",\n" +
                        "                    \"email\": \"\",\n" +
                        "                    \"country\": \"kuala-lumpur\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"Acquire\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"Acquire\",\n" +
                        "                    \"description\": \"Acquire, situated in the busy hustling and bustling suburb of Bangsar, is a boutique offering customers an array of quirky designs, technologies, fashion, and travel luxury items. They feature a lineup of eye-catching emerging brands such as Project Watches, Nannini Eyeware, and others. They offer patrons unique items like Skooba laptop satchels, Addex’s Dolce Radio, along with home lifestyle products from top brands like Serrax, Innit Design, and ForLife designs.\",\n" +
                        "                    \"website\": \"https://www.facebook.com/acquireshop/\",\n" +
                        "                    \"email\": \"\",\n" +
                        "                    \"country\": \"kuala-lumpur\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"ACS\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"ACS\",\n" +
                        "                    \"description\": \"Asia Century Supplies (ACS) specialises in production manufacturing and laser printers. They have also been supplying printer consumable products since 2005. Currently, they boast of over 10,000 customers from different categories such as schools, small and medium business, and even government and public listed companies. They strive to provide high reliability and quality toner cartridges. As putting their customers needs is a high priority, they only elect qualified customer service team members who have an average of 10 years of experience.\",\n" +
                        "                    \"website\": \"http://www.asiacentury.my\",\n" +
                        "                    \"email\": \"\",\n" +
                        "                    \"country\": \"kuala-lumpur\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"Activ Studio\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"Activ Studio\",\n" +
                        "                    \"description\": \"Believing that intimate understanding of each clientele is the way to go for optimum results, Activ Studio provides intensive personal and group training to ensure each and every student attain their fitness goals in a safe and fun environment. While popularising the Electro Muscular Simulation (E.M.S.) training – which has been known to be three times more effective than traditional gym workouts – this boutique training studio also offers the usual fitness classes like yoga, BLT class (that targets butt, legs, and tummy), TRX suspension training, piloxing, and more.\",\n" +
                        "                    \"website\": \"http://www.activstudio.com.my/\",\n" +
                        "                    \"email\": \"\",\n" +
                        "                    \"country\": \"kuala-lumpur\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"Acupaday\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"Acupaday\",\n" +
                        "                    \"description\": \"With walls decorated in vibrant murals of Vespas, Bob Marley, and an assortment of memes, Acupaday exudes a mellow ambiance for those seeking a laid back cafe to indulge in coffee drinks, Western food, and quality time with loved ones. Featuring dishes like homemade pasta, bagel burges, cakes, and caffeilly coffee, patrons can find delectable delights here together with a selection of board games to entertain themselves with.\",\n" +
                        "                    \"website\": \"https://www.facebook.com/CafeAcupaday/?ref=br_ rs&sw_fnr_id=3422159161&fnr_t=0\",\n" +
                        "                    \"email\": \"\",\n" +
                        "                    \"country\": \"kuala-lumpur\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"Adeena Thai Cafe\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"Adeena Thai Cafe\",\n" +
                        "                    \"description\": \"Adeena Thai Cafe, previously located at Rasta TTDI, is now back with their signature Authentic Thai Beef Noodle and Thai Style Porridge. If you’re into spicy dishes, then you must try their Thai Basil Rice with your choice of Chicken, Beef or Prawn and their Tom Yam with your choice of Chicken, Fish Fillet or Prawn. Indulge in the authentic flavours of Thailand here at Adeena Thai Cafe.\",\n" +
                        "                    \"website\": \"\",\n" +
                        "                    \"email\": \"\",\n" +
                        "                    \"country\": \"kuala-lumpur\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"_index\": \"merchants_index\",\n" +
                        "                \"_type\": \"merchants\",\n" +
                        "                \"_id\": \"AD Travel\",\n" +
                        "                \"_score\": 1,\n" +
                        "                \"_source\": {\n" +
                        "                    \"name\": \"AD Travel\",\n" +
                        "                    \"description\": \"Established in 1985 and has since undergone many restructuring processes including a change of ownership, AD Travel has stuck to its roots to provide top-notch travel services and agents to cater to any holiday needs. With a comprehensive network of offices strategically located in Asia, Europe, Australia, and two branches in Johor, interested spectators can explore through its many tours and top attractions that range from overseas to inbound tours. Being members of MATTA and IATA as well, the licensed travel agency has also raked in awards like the top agent award in Malaysia for Sibu Island Resort for 2012.\",\n" +
                        "                    \"website\": \"http://www.adtravel.com.my/\",\n" +
                        "                    \"email\": \"\",\n" +
                        "                    \"country\": \"kuala-lumpur\"\n" +
                        "                }\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "}", MerchantsResponse::class.java
            )
        }

        fun getMerchantArrayList(): ArrayList<Merchant> {
            return ArrayList(getMerchantsResponse().hits.merchants.map { it.merchant })
        }
    }
}
