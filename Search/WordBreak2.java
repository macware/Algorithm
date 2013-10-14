package Search;

import java.util.*;

public class WordBreak2 {

	/*
	 * Why the following solution is wrong? For find all problems, we should
	 * consider whether our solution will produce duplicate items. And it is
	 * usually the case when the question is symmetric.
	 */
	public ArrayList<String> breaking(String s,
			Map<String, ArrayList<String>> cache) {
		if (cache.containsKey(s))
			return cache.get(s);

		ArrayList<String> res = new ArrayList<String>(), left, right;
		String tmp;
		for (int i = 1; i <= s.length(); i++) {
			tmp = s.substring(0, i);
			left = cache.get(tmp);
			if (left == null)
				continue;
			right = breaking(s.substring(i), cache);
			if (left.size() == 0 || right.size() == 0)
				continue;
			for (String ls : left) {
				for (String rs : right) {
					if (ls.length() == 0)
						res.add(rs);
					else if (rs.length() == 0)
						res.add(ls);
					else
						res.add(ls + " " + rs);
				}
			}
		}

		cache.put(s, new ArrayList<String>(res));
		return res;
	}

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return new ArrayList<String>();

		Map<String, ArrayList<String>> cache = new HashMap<String, ArrayList<String>>();
		for (String str : dict) {
			ArrayList<String> al = new ArrayList<String>();
			al.add(str);
			cache.put(str, al);
		}

		ArrayList<String> al = new ArrayList<String>();
		al.add("");
		cache.put("", al);

		return breaking(s, cache);
	}

	/*
	 * DP + DFS
	 */
	public void breaking(int start, String s, boolean[][] seg,
			Set<String> dict, ArrayList<String> res, StringBuilder path) {
		if (start == s.length()) {
			res.add(path.toString());
			return;
		}

		int totalLen = s.length() - start;
		String tmp;
		for (int len = 1; len <= totalLen; len++) {
			if (seg[start][len]) {
				tmp = s.substring(start, start + len);
				if (!dict.contains(tmp))
					continue;
				
				int before = path.length();
				if (before != 0)
					path.append(" ");
				path.append(tmp);
				breaking(start + len, s, seg, dict, res, path);
				path.delete(before, path.length());
			}
		}
	}

	public ArrayList<String> wordBreak2(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return new ArrayList<String>();

		boolean[][] seg = new boolean[s.length()][s.length() + 1];
		int len, i, j;
		String tmp;
		for (len = 1; len <= s.length(); len++) {
			for (i = 0; i <= s.length() - len; i++) {
				tmp = s.substring(i, i + len);
				if (dict.contains(tmp)) {
					seg[i][len] = true;
					continue;
				}

				for (j = 1; j < len; j++) {
					if (seg[i][j] && seg[i + j][len - j]) {
						seg[i][len] = true;
						break;
					}
				}
			}
		}

		ArrayList<String> res = new ArrayList<String>();
		if (!seg[0][s.length()])
			return res;

		StringBuilder path = new StringBuilder();
		breaking(0, s, seg, dict, res, path);

		return res;
	}

	public ArrayList<String> wordBreak_shaotuo(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<String> result = new ArrayList<String>();
        
        if(s == null) return result;
        int len = s.length();
        if(len == 0) return result;
        
        for(int i=len-1; i >= 0; i--) {
            String s1 = s.substring(i, len);
            if( dict.contains(s1) ) {
                if( i == 0 ){
                    result.add(s1);
                    continue;
                } else {
                    String s2 = s.substring(0, i);
                    ArrayList<String> list = wordBreak(s2, dict);
                    ArrayList<String> newlist = new ArrayList<String>();
                    for( String str : list ) {
                        str = str + " " + s1;
                        newlist.add(str);
                    }
                    result.addAll(newlist);
                }
            }
        }
        
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		String[] strs = new String[] { "be", "ellaekgjhibcomc", "ahaklkan",
				"jcm", "lchidklmcone", "ljmdgagaen", "giioojldjkfnno", "el",
				"eibjaffacjll", "hn", "hbjakhjneml", "foi", "nbhf", "aigf",
				"cfdlnc", "fa", "amakgofedhkghgl", "ddhmhdhioh",
				"ijoddeabbiei", "giamcgco", "nholghlfbbendi", "emlc", "m",
				"elgibme", "behkignjenmh", "lodkkjgioe", "doe", "hgflgakna",
				"macghogdidmdm", "ec", "kncigolkog", "ljooio", "lch",
				"gkaclkbjn", "ofiaglfoffl", "alhfbb", "cfmdbgo", "cfcnajknk",
				"jfh", "almbgdjnbbbgmhb", "dmlnnohf", "olojeejfafc",
				"ndgcmgoe", "cmkdjilfeo", "bengdd", "enfg", "dbngiggni",
				"anmkljn", "njdnjdmmfha", "ndimmddfmhe", "hmkdjkhhiilnf",
				"ehd", "jfdl", "dlgki", "bhoflnomibkki", "lg",
				"fjojjnnkdfenhol", "lefhhl", "nimdl", "gejgomblmim",
				"ahbnlmlfmejjj", "glhacaojnf", "mfjdhnhdkm", "do", "fnh",
				"mnmjdk", "hfjgdlnnb", "hniolfhkhbie", "ldgodonogcab",
				"mabjnnohnijhn", "aceojlkmdg", "aedfljg", "cehk", "jag",
				"oniegflnhje", "jo", "maokc", "jkbndc", "djbn", "dajkdblojkf",
				"dmen", "kcdjdocinenc", "cgindbm", "h", "odaof", "cmogcbgj",
				"anjahlgbbmba", "haoe", "ggacnminj", "ilcfjoedhe",
				"klookammgofl", "onnmenn", "mbdneaioo", "jc", "dekgil",
				"bjdfibfd", "hfbnlgmlllcb", "afebehf", "obekljbnh", "eoaedhjk",
				"nobamccd", "mdieojoknf", "komcglmakkaa", "jcliimcc",
				"jmmgbmha", "gdogjnn", "ednembco", "dgno", "jiaheeabifahfmo",
				"djkcgnakkh", "kdkiglgf", "eb", "fmdnlhj", "eicohdciejc",
				"jgofmankkf", "o", "nnmomkmkmiaoga", "njchkccln", "ndamha",
				"eleanmojdi", "ebkl", "jcageehlelcg", "acfddofjihgmn",
				"iklaomfhjm", "io", "igmob", "lfnhnlnigbbignk", "anihfojmedf",
				"nj", "oilcabalhb", "adjfbkfjch", "lbfb", "mgfnngfccb",
				"jhmhggm", "dnllc", "c", "ljim", "jmikd", "mdfimdgac",
				"fhbclgo", "edclcdia", "nelmfjejff", "i", "cmcbbckdnjcoo",
				"cddocce", "hc", "keh", "keofhnhemd", "biln", "mjcnbjmkikon",
				"fekbdnkolahh", "hkfmjbj", "mjoj", "jn", "ilof", "ifhfk",
				"aofmg", "nofljgmmmf", "hcdifeiclbchlf", "imlijgdg",
				"ocdiiemcmbkglm", "nhoekmlkjfoa", "kibffkbleedda",
				"kdhdjekccbkc", "bcbflcag", "jekmkdimnnjjoo", "mmgfljchalbem",
				"kchk", "oi", "ncf", "jembgfa", "l", "kfkeianmmmdacl",
				"ecjkkfggj", "jdgcfnhfjonkhig", "jhagiokii", "nifm", "bbjjlj",
				"adajlokomibfg", "ojk", "lockdel", "bh", "hoojolglchck",
				"conko", "eadi", "kfigoijnfimolen", "g", "dbnj", "cojkbmo",
				"hh", "mcdbh", "ngdmgioen", "ehjagfohnolkho", "dgfgdlc",
				"aoglneoh", "gbc", "ijjckddeicld", "imekih", "liiaecniil",
				"hahejbhgiclb", "fnmojm", "ablihjhggiahhno", "colloaakco",
				"jhobddaanbhmlg", "cbfajfhkoh", "cim", "laghknigabn",
				"dcbnbkegkjam", "gem", "ljjim", "icclogji", "omidhe", "f",
				"giiaclfcjkagl", "ndcjldekjnkekm", "aiikdccohcj", "mkbmb",
				"oomhhafobic", "bkacdjfgbggn", "ahghdoahbi", "hedm", "eeoj",
				"bdgdlfollegej", "eg", "dfeb", "dkffkid", "hcne",
				"gjkohnaaabn", "jfeododjgdhlfbf", "clfkmconnkfb", "abnbkcni",
				"hk", "ghnmhjm", "oibjibmkaibdefa", "hjambim", "oe", "aao",
				"jil", "fmhomflfen", "hlidcklnmb", "hiaonkhd", "bibbmkandf",
				"hke", "bmfcionm", "inhcnlkbkkmjicn", "jckjedhgoghi", "chmik",
				"mnjldknhaec", "hocbccbg", "ljadj", "lciikgnlj",
				"ifjjhkbhifione", "foikblanoco", "ode", "mjc", "fhklofh",
				"mmoklkkog", "hocbojmhffeajo", "ccmmd", "bkkh",
				"nhhgcflniebkme", "lfohikenfbjacli", "cmehijnihijgng", "caa",
				"bmk", "emofof", "jjagiogohfab", "ibh", "eoacdlnodalkjbl",
				"cbbjbbnjom", "iljiomeloehen", "gignlngclmh", "b", "ll",
				"dokgngnocde", "cienegffibgieba", "agbachloidg", "mlelnafokd",
				"nmcmka", "akeogjbjcnf", "nebdic", "a", "efc", "ljdk", "jhcag",
				"bkbikbjgae", "mcjlgjeo", "lo", "dbiofobl", "cehebiljff",
				"eeagngm", "ondahcjiel", "coblanndhlhoggj", "jaobmjml",
				"jfejjinofek", "hhnna", "gdhcn", "acelcomgkgohm", "njkkjkkln",
				"jmc", "hkekoho", "boefec", "cioibfgjmhb", "ebggdbeimn",
				"emhg", "cfghkhii", "d", "k", "khoddedia", "nhje", "eebkfml",
				"bohhd", "kg", "n", "ilgemokdehcbaif", "cldicda", "einij",
				"akmabcgfn", "fmkmcn", "bnlfbagkke", "oakbgjejmcncj",
				"iehdfadgoik", "kkcfo", "jmjkmfcacjjnd", "ndokhh",
				"hjfeelhckkjjmj", "dnomohejbodkb", "jcmblncjadno",
				"oiofcodobiml", "ddmillkncjfdfj", "aihenmkdnhdhkhf",
				"bfdbakeilfdojnc", "jjhbkbne", "aigabk", "cae", "oednojjb",
				"gdoe", "jokjceohkmbm", "offkanbahigo", "kfomigbfddjli",
				"dkkjobgkcejei", "mdilld", "bofkika", "kkinig",
				"cljcflbghjmhmke", "kmbjlgdcbdjn", "bkgbmoahda",
				"kmnajjdemggnfg", "mgjndldil", "iemb", "kehaokgjg", "icign",
				"oijmaolehmoo", "amhgldifmgekhe", "diacnollhi", "lnjhdaafadl",
				"bdfiackhogoje", "ebjlfa", "deabkgfhnead", "gadcob", "haa",
				"dbhnbhjcmmab", "bbmjainilbbej", "dc", "bgjgafnjjflne",
				"ehholgnn", "fmhccbnc", "mdnfl", "feeejdgc", "mfhlobdadooh",
				"ojna", "gkgjnijdbgo", "ghngnhn", "nhnjaiaadiedgg", "nk",
				"hmd", "nmbmijaffogl", "onkcgbgmago", "gfli", "ofjlec",
				"nlfnbkkdc", "hakilani", "bofjdjkhllb", "ocjncleljnecfc",
				"gdonnkodmkejhf", "fiflchanfllgnf", "kaejakoibgln",
				"hmdlfioacgaci", "honmfbcog", "mlacbi", "gf", "ejbbemoeha",
				"acfjegee", "lllflaocnnkeadi", "mdgoebfgacecmbg", "faejgln",
				"kmlmhffgcmekm", "akcjmgdg", "kmhhh", "fdohjehacdln", "e",
				"ojba", "ohadmod", "eaenkdiaokl", "dii", "cgfjaklblafeifo",
				"imoeflkcgbbem", "nbjkmb", "jjgm", "hofgelg",
				"cnihecmdigdgflg", "fnmikkeldjgb", "onlhgonldjaedh", "fmkdn",
				"kfbcbleen", "oejioibnmab", "cg", "meadghbocjnj",
				"hmmdnkegfeieijn", "ijgenomhndlje", "maccdcgfjig", "iabemie",
				"mlfg", "mdblmdaechmeaml", "dhlafgjo", "eabbiila", "kf",
				"oehggehfmijlfmg", "klljaejidfhbon", "akmbgmignoag",
				"jgbkngmigdfm", "kjeelnbn", "ajaa", "mlcjoiaahoiga",
				"oalnielba", "ffmobgkc", "kmhoknfffdmo", "nagjiffnjhh",
				"dlehllomjok", "agaejefhdbk", "nnegoijfdj", "ndl",
				"dhfginocgi", "nflmglgh", "bcd", "gbgjijemmdio", "jk",
				"gidgjbmb", "hi", "lmgoah", "fdebefcech", "ach", "bahaoj",
				"ccmmblgibgjahi", "moid", "jhilgedidndm", "ldiakemnj",
				"bbnibccm", "jkbneoaheaajnm", "clkgmbjlgdnl", "lobbdldifnnijh",
				"dnmih", "jglia", "didicmghfe", "dlhbcfclf", "akbmioocoihkfh",
				"foofdldm", "imenimfcame", "ifekbmgnbdkc", "jjlkaabdollola",
				"gie", "hbaj", "noomfnfccmgaa", "dcjffeg", "nb", "obdb",
				"lolgjflimkib", "eaiigminlakkb", "cia", "hkf", "jknfklaio",
				"igklbiomo", "jfjgh", "ekgnkfnhjcch", "kmonfcclieehlik",
				"oggkmccklnmj", "bedhobcl", "egmnhajcnhcdgb", "imfdhekamfel",
				"bmmkhfdbm", "gnjfbcjlecfn", "llmkgclm", "gafinbnhfe",
				"mlbfedkoeeddfao", "kklcdmglleb", "ckekmeiea", "mi", "kfejn",
				"lm", "mk", "abkoajocfdili", "jidac", "jonhkanccl",
				"lllodjgnmm", "abfeaodlmjkngol", "cdncnh", "lkcb",
				"abhilnmmhijab", "hiljkfakojjld", "mbboobkaolkljo",
				"jhkblobaofgoh", "ncm", "mgbdhmcicomf", "oag", "akmjdd",
				"abkenodnhj", "mljf", "afb", "afejkobmiffeee", "oollnkilabmb",
				"gfaocokmcmjlmb", "cokmecdd", "bo", "endocdnmjiek", "bcf",
				"lhllbagiel", "bhihgofhj", "ffce", "neio", "ofbfiiab", "kjdo",
				"lgfggnamceeo", "kofledoinamcj", "femhndomndoakoa",
				"fmodaigcka", "omakggcalhn", "hhhogmcbjnhelkk", "mgah",
				"jghjjfmk", "ecolelfmcb", "eajjkdncafhhgab", "obno",
				"fifigfeok", "laafjimienff", "beckbbmhmofb", "nafhihmgnikd",
				"cbcfnhlkne", "kao", "nlkfhbm", "fmh", "ohfek", "oj",
				"hifgcgi", "adhkn", "lffgmodeafnn", "ngchmhdbmhmhh",
				"mcffimhnlffab", "blhmkdhbnhbb", "kkb", "lgkine",
				"hgfbdbfffanhik", "joebhbh", "img", "kglcddmloo", "hoflgfao",
				"bdhgdekb", "mggflahnoo", "cmnol", "imnmmgimmedf",
				"mcjmoofomiia", "mlakhbjfnbmgena", "ilhmcnkkeg", "domhbmkcd",
				"fco", "fdio", "cmkoagblnd", "kmihfigmceiiicm", "afgbadbgbaon",
				"menahlemehifooe", "jacokdiiokaic", "limj", "fkedaoomokjbkdi",
				"jkncd", "jblmcmfnegnk", "jjicjhjhbg", "gbfcead", "jf",
				"aifnkmnao", "effmhlhchngknl", "odhjeib", "ohcgmgb", "bgbd",
				"am", "kkjfbdlh", "hgbjakkokjgooel", "jbeokiakf", "flaoba",
				"cifcdnanmk", "mice", "ihhofdai", "ldnfmeiemhf",
				"kefbbohhgineacj", "bi", "njfie", "ociodahlomoekkf",
				"andhoindeca", "ajnndjocjeg", "bmijkmjbbkgbbh", "feanh",
				"bjemcefkfcaenal", "edfdenghinm", "moal", "ndbjdmijh",
				"enccnhmoifa", "dbckadjibam", "gd", "oglj", "aldjelhbemle",
				"cmbkofkcoe", "ihciacibeh", "lcojkclhmibgoif", "jfmjncnolfj",
				"gfcmcabhjki", "aggfmakaanjb", "mhbelld", "hon",
				"nkfoikcddehcah", "kggbigknacmohb", "jbkgndofcmaaohh",
				"gkjano", "afhhhh", "mjng", "jilckm", "dekkedjehmenbm", "clfm",
				"acmhbkdadgena", "oenokachg", "lhiea", "dceiag", "eebgj",
				"oolifidh", "dj", "cdfn", "eghdglgiok", "jdhegkefhbdhkm",
				"mhgngafea", "akabbcjkdnbc", "gcbn", "kimdgahf", "oc" };
		for (String str : strs)
			dict.add(str);
		WordBreak2 wb2 = new WordBreak2();
		System.out
				.println(wb2.wordBreak2("fajbeokiakfmlacbinjdnjdmmfha", dict).size());
	}

}
