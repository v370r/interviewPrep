package arrays.Sorting_Searching.searching.rangedBinarySearch;

/*
 * https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
 * 
 * You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles together.
 * You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. 
 * Each child can take at most one pile of candies and some piles of candies may go unused.
 * Input: candies = [5,8,6], k = 3
    Output: 5
    Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1. 
    We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.
    = > solution space is left = 0 , right = maximum candies piles
 */
public class maximumCandels {
    public static void main(String[] args) {
        int candies[] = { 2494780, 1592837, 7688066, 1868774, 2432917, 5203720, 949491, 7513696, 4187818, 9428510,
                5691922, 6916435, 9270585, 4906175, 2003057, 1758771, 4487240, 7978392, 3657473, 1527836, 2864782,
                8011043, 423236, 2215550, 831522, 9193620, 2660916, 9943144, 5565788, 7744189, 6842044, 7830828,
                4113180, 632993, 5867911, 981359, 3235455, 377855, 4108670, 6787177, 6062693, 1607550, 8417505, 7466966,
                4209082, 167983, 648973, 8945833, 6311280, 1039771, 5637121, 2712141, 2267125, 5395616, 5772695,
                6029385, 3765884, 9083820, 6116481, 8371054, 9666735, 4245829, 3627056, 9416857, 1975584, 279098,
                9426523, 5975784, 1966958, 5229593, 8410303, 2515621, 90934, 7882119, 348048, 2436749, 3141310, 810727,
                2862321, 6756687, 1263096, 7329788, 715981, 3378520, 5318321, 1489152, 4973294, 1794353, 2724016,
                2588458, 5451653, 6296651, 3445857, 9014893, 2784180, 4768509, 7080332, 2257597, 7481798, 5687098,
                6387657, 5627678, 1538697, 4773688, 9158032, 412261, 3734161, 4423426, 5319883, 5482817, 3289097,
                1864011, 1872358, 7572241, 4245128, 121622, 810527, 978440, 3534327, 1592144, 4736178, 9730057, 6501686,
                7658105, 9493859, 2334335, 3485606, 979827, 4929865, 4855003, 5253247, 1275191, 9553292, 8225221,
                5112034, 7429239, 4226044, 5630380, 4136, 2163491, 7931703, 2506612, 5094891, 5852150, 2138302, 3490340,
                2846484, 9552205, 2124523, 4992697, 9997314, 3480222, 7724914, 6075477, 239553, 2560156, 2548282,
                4661182, 4077902, 3206010, 2020318, 9834837, 1064944, 8942640, 2818688, 1745850, 2234273, 4346877,
                4793002, 1475416, 1984778, 7292976, 9230774, 516979, 3725382, 2230799, 7103413, 564602, 5449152,
                6581035, 1223135, 5406234, 8275152, 7484633, 2688325, 3742870, 1896520, 973684, 4774822, 7162637,
                9446572, 5962073, 7964898, 5400997, 5456603, 215018, 6182802, 9503057, 1784673, 8128289, 1510105,
                5346135, 1934770, 6791075, 806198, 5487134, 8386709, 6717213, 9637423, 1013930, 9923593, 6055561,
                1615945, 1079970, 8970840, 8104658, 9752171, 158761, 1705288, 7642781, 464395, 2992243, 4034786,
                8657949, 6635190, 993488, 5268043, 5028869, 646487, 8138277, 3308945, 7333146, 2365712, 9019782,
                1057754, 5046020, 7179224, 9168121, 1005573, 8013763, 1462340, 4500589, 3056908, 2989539, 2048040,
                6114348, 6218971, 4541278, 3736172, 1968673, 1406348, 5982338, 5369031, 2557819, 3509955, 3767629,
                3231068, 6137323, 9702200, 2723096, 2978182, 2426995, 2998835, 2194860, 9275454, 1288128, 5701108,
                1095275, 1242322, 2237455, 4132958, 4841868, 4621175, 8508083, 6194082, 7897659, 991763, 6777117,
                5502096, 5476455, 921016, 9410106, 8810762, 3538519, 3857503, 7519124, 3854553, 3818108, 7791887,
                8714519, 7940073, 8808549, 7681591, 405633, 4182839, 1264474, 6800557, 3669603, 7503524, 559956,
                2084406, 8150159, 6794091, 3073105, 1456905, 3360911, 9832904, 5043428, 1475634, 1287189, 1642232,
                5186696, 7323278, 9201213, 7351415, 5097151, 2351922, 4334524, 1271661, 1714102, 3241113, 3465649,
                4123896, 8845070, 8535291, 4301207, 5245867, 7631795, 4235496, 2464379, 6190668, 2970007, 6718324,
                8703552, 3298942, 7682849, 7709598, 5513526, 2655610, 5331756, 6323702, 3347308, 859878, 2916748,
                2514241, 3740509, 8255655, 554854, 5260504, 4610823, 781509, 2023588, 692729, 2482577, 3647858, 4134895,
                8662328, 4476082, 2729484, 391730, 452918, 8659882, 9996083, 6323867, 8797353, 5965147, 9846406, 7833,
                1261088, 5681943, 8552571, 7995654, 9805838, 1144938, 7201345, 4897034, 5499132, 3671108, 2881228,
                8600763, 4115235, 2037668, 3324863, 2806800, 2661116, 8217722, 5920239, 4351622, 7813220, 3047471,
                5309977, 5782637, 4492736, 7633472, 501344, 2243978, 647390, 6305712, 5086454, 8110370, 2215175,
                6793646, 1347983, 973461, 3062250, 2091108, 8129800, 4317042, 6801912, 6542074, 3052400, 3089334,
                8400535, 2839621, 5897902, 4742449, 3438920, 7500911, 7172494, 582106, 2348912, 6031245, 7472650,
                9188661, 2980941, 5226558, 3480061, 3872534, 6939792, 5778060, 2119099, 487720, 2213801, 751796,
                6746544, 3967405, 1273743, 9242967, 8355399, 6846290, 9784093, 7933234, 2063265, 6030950, 682986,
                1394200, 5322377, 9362214, 2116434, 238725, 9695593, 5241806, 4039261, 7567464, 4403748, 6491794,
                8737438, 9837981, 8456266, 1407914, 5683743, 7120424, 1216068, 3407115, 9552904, 929951, 3378436,
                4155228, 2678673, 3023332, 9006463, 4716581, 5433223, 9902288, 8225786, 6643973, 9579363, 6994716,
                1066708, 1725341, 5714200, 8543598, 6033833, 2773577, 5337671, 2944761, 3759879, 7929195, 1734361,
                857140, 4169812, 6339958, 7543810, 8813713, 9013511, 8959576, 2337655, 3227535, 4571201, 5601673,
                8221974, 9190189, 3657161, 3326783, 5157930, 2612959, 9097090, 1308427, 1042471, 9329961, 5874199,
                9102780, 9842209, 9518910, 7660275, 2973427, 6105988, 4487204, 1208432, 7878176, 3045071, 8242099,
                1517925, 7821318, 2816466, 2740746, 183625, 2291983, 1884385, 7961550, 3648361, 5321274, 425703,
                5779949, 8708439, 7207471, 9112853, 4658772, 3179493, 3017394, 4310338, 3733292, 3752647, 1541183,
                9819335, 5940626, 8926437, 5780035, 6195752, 7236357, 95348, 8343911, 9370356, 9709576, 4668870,
                8261810, 5711969, 8698624, 9075904, 1368348, 1844095, 1352709, 1587079, 3187117, 2737276, 6387597,
                2700262, 7746739, 1307141, 8965561, 3036908, 1054972, 7256175, 1037188, 7456675, 4800524, 4455038,
                1973212, 752026, 4855716, 1163753, 9269014, 2057811, 5991999, 2924221, 212312, 5166160, 5658120, 634576,
                54703, 7500069, 7089810, 6382392, 6867699, 1680577, 2650024, 5648555, 8058584, 3303921, 1632944,
                8783653, 133414, 9994439, 3352969, 9045560, 8043249, 2473263, 5448143, 3497002, 3688278, 4360205,
                5782828, 9362607, 6859394, 4792880, 431032, 5447278, 7100268, 3953309, 9855738, 7141336, 2922969,
                4512870, 193915, 1725373, 7707041, 7927258, 8199187, 609819, 3110768, 6174060, 1441927, 2778397,
                9808858, 7311502, 5620748, 9153331, 3215905, 7137462, 4766436, 1988630, 6304905, 8822803, 7600903,
                5344413, 4121484, 4106675, 6332901, 4476722, 3422441, 7586873, 7385359, 5883199, 7088065, 6775569,
                2395307, 9708271, 4717557, 5364816, 1449704, 1276450, 262222, 6651864, 9667646, 2274460, 3539727,
                6257293, 3343136, 5529029, 4551152, 2097369, 2861170, 3848401, 2033113, 9716761, 5562400, 291796,
                5024120, 8125655, 1272542, 5954161, 7689700, 2384990, 1385399, 7161030, 5410811, 9117624, 5943441,
                6197102, 7865117, 6134922, 2794972, 4360478, 904977, 1777601, 9174224, 420352, 1296545, 7464012,
                1238098, 4432290, 28216, 2818401, 1076633, 844720, 6156100, 3474213, 7731444, 9254894, 880653, 414789,
                9796951, 5158537, 2386537, 4118255, 1955887, 1596869, 5783011, 1574439, 5482967, 140963, 1817223,
                3481004, 7843480, 6433394, 9890578, 8126601, 8223229, 462395, 4637333, 5275225, 6417070, 8029331,
                6340041, 9288136, 3572711, 2217909, 7297045, 447815, 176431, 2805299, 792663, 141231, 4044725, 9441799,
                647838, 8778154, 9284720, 564397, 9141236, 7848789, 6567056, 1324287, 1941131, 5988009, 9827453,
                7306078, 8132425, 4756998, 8323653, 7021626, 9235031, 9509994, 3584172, 9327365, 1412370, 7312140,
                2505389, 8001028, 4951061, 1802504, 3910576, 6262532, 4296997, 7478511, 284141, 6101068, 1659066,
                759759, 2949042, 5928787, 6633610, 9111255, 7754838, 9712723, 2782464, 8364805, 3912283, 1630354,
                413739, 5916654, 8402110, 4319030, 3191028, 2025469, 7388104, 8784518, 4050168, 545155, 2969128,
                4713876, 2019979, 1275710, 7301889, 8365967, 7416420, 7037235, 1231197, 6916410, 9696633, 5324107,
                2093616, 8177341, 7225458, 4318893, 4193734, 8160763, 9709184, 5034723, 4691669, 2162899, 4563130,
                3260374, 8883025, 1029635, 3507990, 7736888, 1162754, 1501833, 4938312, 2500314, 7535756, 8563888,
                4926232, 3157092, 7226281, 6781364, 2990770, 6291667, 2629609, 4468281, 9410076, 2575552, 8459816,
                1259218, 9318975, 296579, 91341, 7659636, 8595058, 8476882, 440785, 4087031, 9132481, 4734688, 8075209,
                6583246, 7770899, 2733094, 3550386, 4840672, 4495569, 9881221, 7324373, 6465634, 9750566, 3453050,
                8535377, 4524371, 4673335, 9888984, 1510179, 3614705, 3563932, 5790414, 5345507, 2010459, 9452970,
                3808100, 9531061, 6377557, 4876901, 9069725, 2265685, 1272792, 3148824, 7767635, 5865103, 3597675,
                738008, 4369757, 5150275, 1583032, 6871488, 5933177, 3210926, 2591951, 7839708, 7642339, 902705,
                4249715, 5783113, 9670573, 7897801, 1742408, 2637766, 5987693, 5979987, 4411105, 9402236, 8587692,
                868348, 1385389, 1546038, 4130936, 2948087, 339041, 7478141, 4057802, 1031852, 8944754, 344562, 1347964,
                3601459, 240509, 4424932, 4833850, 2742246, 989420, 8964434, 1836751, 8448218, 9523324, 2035313,
                8533157, 3781276, 4454873, 1515760, 1561555, 2897149, 6852321, 4151321, 3797055, 9954523, 9046386,
                1599375, 2114987, 5890229, 3713084, 6692913, 2458999, 2855746, 9634348, 2886175, 32155, 1611441,
                4297891, 119977, 4794992, 4322220, 8061409, 1741325, 2656939, 335957, 3017052, 7158137, 3262972,
                2513001, 7281659, 9954706, 2580175, 982283, 3592317, 5065104, 8758696, 625729, 9820192, 7168710,
                6495892, 8154701, 6803500, 8054491, 8207733, 3770564, 9317334, 6461394, 499070, 1192959, 3025695,
                6074252, 8034023, 8631396, 5392750, 183442, 9820499, 8845051, 7754266, 4946977, 2321650, 1759574 };
        long children = 4686898339l;
        System.out.println("Maximum candies that can be allocated : " + maximizeCandies(candies, children));
    }

    private static int maximizeCandies(int[] candies, long children) {
        int left = 0, right = 0, mid;
        for (int i = 0; i < candies.length; i++) {
            right = Math.max(candies[i], right);
        }
        int ans = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (checkPossible(candies, mid) >= children) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static long checkPossible(int[] candies, int mid) {
        long childs = 0;
        for (int i = 0; i < candies.length; i++) {
            childs += 1.0 * candies[i] / mid;
        }
        return childs;
    }
}
