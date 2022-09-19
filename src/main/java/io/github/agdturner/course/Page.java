/*
 * Copyright 2022 Centre for Computational Geography.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.agdturner.course;

import io.github.agdturner.core.PageID;
import io.github.agdturner.core.ReferenceID;
import io.github.agdturner.course.python.intro.pages.Home;
import java.nio.file.Paths;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * For course pages.
 *
 * @author Andy Turner
 */
public abstract class Page extends io.github.agdturner.Page {

    /**
     * The Course.
     */
    protected final Course c;

    /**
     * Create a new instance.
     *
     * @param name What {@link #name} is set to.
     * @param label What {@link #label} is set to.
     * @param c What {@code #c} is set to.
     */
    public Page(String name, String label, Course c) {
        super(name, label, new PageID(c.coursePages.size()),
                Paths.get(c.courseDir.toString(), name));
        this.c = c;
    }

    @Override
    public void writeH1(String name) {
        super.writeH1(name);
        w.add(c.getNavigationButtons());
    }

    /**
     * Adds navigation section at the bottom of the page.
     */
    public String getNavigation() {
        StringBuilder sb = new StringBuilder("<div><nav>");
        if (this instanceof Home) {
            sb.append(getLinkButtonNext(c.coursePages.get(0)));
        } else {
            sb.append(Web_ContentWriter.getLinkButton(
                    Paths.get(c.homePage.p.toString(), "index.html"),
                    c.homePage.name));
            int n = c.coursePages.size();
            if (this instanceof Index) {
                sb.append(getLinkButtonPrev(c.coursePages.get(n - 1)));
                sb.append(getLinkButtonNext(c.references));
            } else if (this instanceof References) {
                sb.append(getLinkButtonPrev(c.index));
            } else {
                if (this.id.id > 0) {
                    sb.append(getLinkButtonPrev(c.coursePages.get(this.id.id - 1)));
                }
                if (this.id.id < n - 2) {
                    sb.append(getLinkButtonNext(c.coursePages.get(this.id.id + 1)));
                } else {
                    sb.append(getLinkButtonNext(c.index));
                }
            }
        }
        return sb.toString();
    }
    
    protected String getLinkButtonNext(Page p) {
        return getLinkButton(p, "Next: ");
    }

    protected String getLinkButtonPrev(Page p) {
        return getLinkButton(p, "Prev: ");
    }

    protected String getLinkButton(Page p, String type) {
        return Web_ContentWriter.getLinkButton(
                Paths.get(p.p.toString(), "index.html"),
                type + p.label);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a Page.
     *
     * @param linkName The name of the Wikipedia article and section (spaces are
     * replaced with underscores) and the text for the link returned.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWikipediaReference(String linkName) {
        return addWikipediaReference(linkName, linkName);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a Page.
     *
     * @param linkName The name of the Wikipedia article and section (spaces are
     * replaced with underscores).
     * @param linkText The text for the link returned.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWikipediaReference(String linkName, String linkText) {
        String resourceName = "Wikipedia";
        String url = "https://en.wikipedia.org/wiki/" + linkName.replace(' ', '_');
        return addWebReference(url, linkName, linkText, resourceName);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a Page.
     *
     * @param url The url of the Web resource to reference.
     * @param linkName The name for the link in the reference prepended with
     * resourceName. This is also used as the link Text that is returned.
     * @param resourceName Prepended to linkName (with a space added) for the
     * reference.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWebReference(String url, String linkName, String resourceName) {
        return addWebReference(url, linkName, linkName, resourceName);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a Page.
     *
     * @param url The url of the Web resource to reference.
     * @param linkName The name for the link in the reference prepended with
     * resourceName.
     * @param linkText The text for the link returned.
     * @param resourceName Prepended to linkName (with a space added) for the
     * reference.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWebReference(String url, String linkName, String linkText,
            String resourceName) {
        String referenceName = resourceName + " " + linkName;
        if (!c.references.referenceNameToReferenceID.containsKey(referenceName)) {
            ReferenceID rID = new ReferenceID(c.iReference);
            c.references.referenceNameToReferenceID.put(referenceName, rID);
            c.references.referenceIDToReferenceURL.put(rID, url);
            c.iReference++;
        }
        return Web_ContentWriter.getLink(url, linkText);
    }

}
