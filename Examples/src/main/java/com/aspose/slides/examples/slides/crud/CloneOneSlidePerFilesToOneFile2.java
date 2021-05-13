package com.aspose.slides.examples.slides.crud;

import com.aspose.slides.ISlideCollection;
import com.aspose.slides.License;
import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import com.aspose.slides.examples.RunExamples;


public class CloneOneSlidePerFilesToOneFile2 {
    public static void main(String[] args) {
        //ExStart:CloneAnotherPresentationAtSpecifiedPosition
        // The path to the documents directory.
        String dataDir = RunExamples.getDataDir_Slides_Presentations_CRUD();

        License license = new License();
        license.setLicense(dataDir + "Aspose.Slides.Java.lic");

        // Instantiate Presentation class for destination presentation (where slide is to be cloned)
        Presentation destPres = new Presentation();
        ISlideCollection slideCollection = destPres.getSlides();

        Presentation sourcePresentation = null;

        try {
            try {
                for (int i = 1; i <= 3; i++) {
                    sourcePresentation = new Presentation(dataDir + "/CloneOneSlidePerFilesToOneFile2/AccessSlides" + i + ".pptx");
                    slideCollection.insertClone(0, sourcePresentation.getSlides().get_Item(i-1));
                }

                destPres.save(dataDir + "CloneOneSlidePerFilesToOneFile2_out.pptx", SaveFormat.Pptx);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (destPres != null) destPres.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sourcePresentation != null) sourcePresentation.dispose();
        }

        System.out.println("finish");
        //ExEnd:CloneAnotherPresentationAtSpecifiedPosition
    }
}
