(ns info.radmen.kennyfy-test
  (:require [clojure.test :refer :all]
            [info.radmen.kennyfy :refer :all]))

(def lorem-ipsum "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas eget leo sit amet mauris dapibus congue. In semper maximus suscipit.")

(def kenny-ipsum "Pmfppfpffmppppm mffpfmfmmfmfppm mpmppfpmfppfpff fmmmfffmp mmmppmmppfmp, mmfppfpppfmmmppmmffmpmppfmpfmfpff mmmmpmmffpfmmfffmmmmfmffpppmfm mpppmfmfffmp. Ppmmmmmppmmfmpppppmmmfmm mppmfmmppfmp pmfmppppf fmmmfffmp mmmppmmppfmp ppmmmmfmfpffmfffmm mpmmmmpfmmffmmpfmffmm mmfppfpppmfmfmfmpp. Mffppp fmmmppppmpfmmpppff ppmmmmfpfmffppmfmffmm fmmfmffmmmmfmffpfmmfffmp.")

(deftest kennyfy
  (testing "Encodes to kenny-speak."
    (is (= (kenny-speak lorem-ipsum) kenny-ipsum)))
  (testing "Decodes kenny-speak"
    (is (= (kenny-translate kenny-ipsum) lorem-ipsum))))
